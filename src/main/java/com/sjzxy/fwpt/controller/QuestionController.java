package com.sjzxy.fwpt.controller;

import com.sjzxy.fwpt.entity.QuesSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scz
 */
@RestController
@Api(value = "问题咨询相关接口")
@RequestMapping("/question")
public class QuestionController {


    /**
     * 轮播展示分类
     */

    /**
     * 查询全部子分类id
     * 如果父分类pid为空，则返回该子分类信息
     *
     */
    @ApiOperation(value = "查询全部子分类信息")
    @PostMapping("/sort")
    public QuesSort getAllSort(){
        QuesSort quesSort = null;
        return null;
    }

    @ApiOperation(value = "根据分类id查询该分类下的问题数、讨论数、讨论人数")
    @PostMapping("/questionAndReply")
    public void getQuestionAndReply(){

    }

    @ApiOperation(value = "根据分类id去question表中查找问题id和创建者id(create_by)并统计问题数")
    @PostMapping("/1")
    public void getQuestionIdAndCreaterId(){

    }

    @ApiOperation(value = "根据问题id（即replay表中的qid）去reply表中查询回答id，回答数，创建者id（create_by）")
    @PostMapping("/2")
    public void getReplyId(){

    }

    @ApiOperation(value = "根据回答id集合去comment表中查询评论数")
    @PostMapping("/3")
    public void getCommentNum(){

    }


    /**
     * 下拉框，根据分类进行搜索：
     */

    @ApiOperation(value = "1．根据模块id1查询全部父分类名称（id,name）；（sort表）")
    @PostMapping("/4")
    public void getAllParentSort(){

    }


    @ApiOperation(value = "2．根据分类id查询其子分类信息（id，name）；（sort表）")
    @PostMapping("/5")
    public void getSort(){

    }

    @ApiOperation(value = "3．根据分类id查询对应的全部问题信息" +
            "（问题id，标题，内容，创建者姓名，创建者头像，创建时间，问题类别，回答人数，点赞数，是否被解决），" +
            "如果是父分类，要查询其全部子分类对应的问题信息（懒加载）；（sort表，question表）")
    @PostMapping("6")
    public void get(){

    }

    @ApiOperation(value = "4．查询全部问题信息（问题id，标题，内容，创建者姓名，创建者头像，创建时间，问题类别，回答人数，点赞数，是否被解决）；（懒加载）（question表）")
    @PostMapping("7")
    public void get2(){

    }


    @ApiOperation(value = "创建者头像和姓名：根据创建者id去users表查询头像和姓名。")
    @PostMapping("8")
    public void get3(){

    }

    /**
     * 搜索栏，结合分类根据关键字进行搜索
     */
    @ApiOperation(value = "把“选择分类”传给后台，如果有分类id就传分类id，如果没有就传空，根据分类id和关键字查询问题信息" +
            "（问题id，标题，内容，创建者，创建者头像，创建时间，问题类别，回答人数，点赞数，是否被解决）；" +
            "根据分类id和模糊（like关键字content）查询问题。（question表）")
    @PostMapping("9")
    public void get4(){

    }


    /**
     * 仅看未解决
     */
    @ApiOperation(value = "根据类别查询出的、关键字查询出的 问题集合，找到问题id，根据问题id集合，查看是否被解决，展示已解决的。")
    @PostMapping("10")
    public void get5(){

    }

    /**
     * 问题展示部分，点击回答按钮：
     */

    @ApiOperation(value = "根据问题id查询全部回答（回答id，创建者id，创建者头像，创建时间，具体内容，点赞数，评论数）")
    @PostMapping("11")
    public void get6(){

    }

    @ApiOperation(value = "创建者姓名和头像：根据创建者id去users表查询姓名和头像。")
    @PostMapping("12")
    public void get7(){

    }

    @ApiOperation(value = "评论数：根据回答id去comment表中查询评论数。")
    @PostMapping("13")
    public void get8(){

    }

    /**
     * 回答展示部分，点击评论按钮
     */
    @ApiOperation(value = "根据回答id查询全部评论（评论id，创建者id，创建者头像，创建时间，具体内容，点赞数）；")
    @PostMapping("14")
    public void get9(){

    }


    /**
     * 评论展示部分，点击回复按钮
     */

    @ApiOperation(value = "@该用户，将该用户的个人信息链接呈现到发表评论框中。")
    @PostMapping("16")
    public void get10(){

    }


    /**
     * 添加回答、评论信息；
     */


    /**
     * 所有分类展示：
     */
    @ApiOperation(value = "根据模块id1查询全部子分类名称；")
    @PostMapping("15")
    public void get11(){

    }

    /**
     * 热门问题展示：回答数+评论数决定热门问题
     * 计算回答和评论数量总和，展示前十条记录。
     */
    @ApiOperation(value = "根据模块id查询问题id集合；")
    @PostMapping("17")
    public void get12(){

    }

    @ApiOperation(value = "根据问题id集合查询回答id，统计回答数")
    @PostMapping("18")
    public void get14(){

    }

    @ApiOperation(value = "根据回答id集合查询评论数量；")
    @PostMapping("19")
    public void get15(){

    }



}
