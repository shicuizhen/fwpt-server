package com.sjzxy.fwpt.service.impl;

import com.sjzxy.fwpt.common.enums.ResultCodeEnum;
import com.sjzxy.fwpt.common.exception.BusinessException;
import com.sjzxy.fwpt.common.response.BaseResponse;
import com.sjzxy.fwpt.entity.Major;
import com.sjzxy.fwpt.entity.Users;
import com.sjzxy.fwpt.repository.CollegeRepository;
import com.sjzxy.fwpt.repository.MajorRepository;
import com.sjzxy.fwpt.repository.UsersRepository;
import com.sjzxy.fwpt.service.UsersService;
import com.sjzxy.fwpt.util.ImgBase64ToImgFile;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Value("${defaultImg}")
    private String defaultImg;

    @Override
    public BaseResponse addUsers(Users users) {
        if (users.getPhotoAddress() == ""){
            users.setPhotoAddress(defaultImg);
        }
        if (usersRepository.findAllBySno(users.getSno()) != null){
            return BaseResponse.error();
        }else {
            users.setCreateTime(new Date());
            usersRepository.save(users);
            return BaseResponse.ok();
        }
    }

    @Override
    public BaseResponse editUsers(Users users) {
        if (users.getPhotoAddress() == ""){
            users.setPhotoAddress(defaultImg);
        }
        usersRepository.save(users);
        return BaseResponse.ok();
    }

    @Override
    public void delUsers(int id) {
        usersRepository.deleteById((long) id);
    }

    @Override
    public Users updateUsers(Users users){
        return usersRepository.save(users);
    }

    @Override
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    // TODO 查询用户信息
    @Override
    public Optional<Users> getUsersByUsername(String username) {
        return usersRepository.findAllByName(username);
    }



    @Override
    public BaseResponse login(String sno, String password) {
        Users users = usersRepository.findAllBySno(sno);
        if (users == null){
            return BaseResponse.error().data(ResultCodeEnum.USER_IS_NOT_EXIT.getMessage());
        }
        if (!password.equals(users.getPassword())){
            return BaseResponse.error().data(ResultCodeEnum.PASSWORD_ERROR.getMessage());
        }
        int uid = users.getId();
        return BaseResponse.ok().data(uid);
    }

    @Override
    public Map findByUid(int uid) {
        List list = new ArrayList();
        list.add(usersRepository.findAllById(uid));
        return (Map) getUserData(list).get(0);
    }

    @Override
    public String getUsersById(Integer uid) {
        return usersRepository.findUsersById(uid).getNick();
    }

    @Value("${folderPath}")
    private String folderPath;

    @SneakyThrows
    @Override
    public String getImg(String img) {

        //指定存放头像图片的文件夹目录
        String imgPath = folderPath + "/" + Math.round(Math.random() * 100000) + ".jpg";

        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            throw new BusinessException(ResultCodeEnum.FILE_FOLDER_NOT_EXIST);
        }
        //调用静态方法，实现图片格式转换
        try {
            ImgBase64ToImgFile.getImgBase64ToImgFile(img, imgPath);
            return imgPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Autowired
    MajorRepository majorRepository;

    @Autowired
    CollegeRepository collegeRepository;

    List getUserData(List<Users> list){
        List list1 = new ArrayList();
        for (int i = 0;i<list.size();i++){
            Map map = new HashMap();
            map.put("id",list.get(i).getId());
            map.put("sno",list.get(i).getSno());
            map.put("name",list.get(i).getName());
            map.put("password",list.get(i).getPassword());
            map.put("nick",list.get(i).getNick());
            map.put("sex",list.get(i).getSex());
            map.put("birthday",new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getBirthday()));
            map.put("photoAddress",list.get(i).getPhotoAddress());
            map.put("grade",list.get(i).getGrade());
            map.put("createTime",list.get(i).getCreateTime());

            Major major = majorRepository.findAllById(list.get(i).getMajor());

            map.put("major",major);

            map.put("phone",list.get(i).getPhone());
            map.put("email",list.get(i).getEmail());
            list1.add(map);
        }
        return list1;
    }

}
