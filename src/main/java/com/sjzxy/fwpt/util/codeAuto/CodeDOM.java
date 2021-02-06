package com.sjzxy.fwpt.util.codeAuto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * jpa自动生成代码
 */
@Slf4j
public class CodeDOM {

    /**
approve
lost_claim
lost_information
lost_kind
lost_place
ques_comment
ques_like
ques_reply
ques_report
ques_sort
users
ques_information
     */

    /**
     * 数据库名
     */
    private String sqlRepository = "select_seat";
    /**
     * 表名
     */
    private String tableName;

    /**
     * 基础路径
     */
    private String basePackage_;
    private String basePath;

    /**
     * 构造参数，出入表名
     */
    private CodeDOM(String tableName) {
        this.tableName = tableName;
        basePackage_ = "com\\sjzxy\\fwpt\\";
        //在类中作为package声明
        basePath = System.getProperty("user.dir") + "\\src\\main\\java\\" + basePackage_;

    }

    /**
     * 创建entity实体类
     */
    private void createEntity(List<TableInfo> tableInfos) {
        File file = FileUtil.createFile(basePath + "entity\\" + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + ".java");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "package " + basePackage_.replaceAll("\\\\", ".") + "entity;\n" +
                        "\n" +
                        "import lombok.Data;\n" +
                        "import javax.persistence.*;\n" +
                        "import java.io.Serializable;\n" +
                        "import java.util.Date;\n" +
                        "import io.swagger.annotations.ApiModel;\n" +
                        "import io.swagger.annotations.ApiModelProperty;\n" +
                        "\n" +
                        "@ApiModel(description= \"" + tableName + "\")\n" +
                        "@Entity\n" +
                        "@Table(name = \"" + tableName + "\")\n" +
                        "@Data\n" +
                        "public class " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + " implements Serializable {\n"+
                        "\n"
        );
        //遍历设置属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                stringBuffer.append("    @Id\n");
            }
            //自增
            if ("auto_increment".equals(tableInfo.getExtra())) {
                stringBuffer.append("    @GeneratedValue(strategy= GenerationType.IDENTITY)\n");
            }
            //swagger注解
            stringBuffer.append("    @Column(name = \""+  tableInfo.getColumnName() +"\" )\n");
            stringBuffer.append("    @ApiModelProperty(value = \""+  tableInfo.getColumnComment() +"\" )\n");
            stringBuffer.append("    private " + StringUtil.typeMapping(tableInfo.getDataType()) + " " + StringUtil.camelCaseName(tableInfo.getColumnName()) + ";" + "\n\n");
        }
        stringBuffer.append("}");
        FileUtil.fileWriter(file, stringBuffer);
    }

    /**
     * 创建repository类
     */
    private void createRepository(List<TableInfo> tableInfos) {
        File file = FileUtil.createFile(basePath + "repository\\" + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Repository.java");
        StringBuffer stringBuffer = new StringBuffer();
        String t = "String";
        //遍历属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                t = StringUtil.typeMapping(tableInfo.getDataType());
            }
        }
        stringBuffer.append(
                "package " + basePackage_.replaceAll("\\\\", ".") + "repository;\n" +
                        "\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "entity." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + ";\n" +
                        "import org.springframework.stereotype.Repository;\n" +
                        "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                        "\n" +
                        "@Repository\n" +
                        "public interface " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Repository " + "extends JpaRepository<"+ StringUtil.captureName(StringUtil.camelCaseName(tableName)) +", Long>" + " {"
        );
        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtil.fileWriter(file, stringBuffer);
    }

    /**
     * 创建service类
     */
    private void createService(List<TableInfo> tableInfos) {
        File file = FileUtil.createFile(basePath + "service\\" + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Service.java");
        StringBuffer stringBuffer = new StringBuffer();
        String t = "String";
        //遍历属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                t = StringUtil.typeMapping(tableInfo.getDataType());
            }
        }



        stringBuffer.append(
                "package " + basePackage_.replaceAll("\\\\", ".") + "service;\n" +
                        "\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "entity." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + ";\n" +
                        "\n" +
                        "import java.util.List;\n"+
                        "\n" +
                        "public interface " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Service" + " {\n" +
                        "\n"
        );

        ServiceBosy.getServiceImplBody(stringBuffer,tableName);

        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtil.fileWriter(file, stringBuffer);

        //Impl
        File file1 = FileUtil.createFile(basePath + "service\\impl\\" + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "ServiceImpl.java");
        StringBuffer stringBuffer1 = new StringBuffer();

        stringBuffer1.append(
                "package " + basePackage_.replaceAll("\\\\", ".") + "service.impl;\n" +
                        "\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "entity." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + ";\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "repository." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Repository;\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "service." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Service;\n" +
                        "import org.springframework.beans.factory.annotation.Autowired;\n" +
                        "import org.springframework.stereotype.Service;\n" +
                        "import org.springframework.transaction.annotation.Transactional;\n" +
                        "import java.util.List;\n" +
                        "\n"
        );

        stringBuffer1.append(
                "@Service\n" +
                "@Transactional\n" +
                "public class " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "ServiceImpl "+ "implements " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Service{" +
                "\n\n"
        );

        stringBuffer1 = ServiceBosy.getServiceBody(stringBuffer1,tableName);

        stringBuffer1.append(
                "\n" +
                "}"
        );

        FileUtil.fileWriter(file1, stringBuffer1);
    }

    /**
     * 创建controller类
     */
    private void createController(List<TableInfo> tableInfos) {
        File file = FileUtil.createFile(basePath + "controller\\" + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Controller.java");
        StringBuffer stringBuffer = new StringBuffer();
        String t = "String";
        //遍历属性
        for (TableInfo tableInfo : tableInfos) {
            //主键
            if ("PRI".equals(tableInfo.getColumnKey())) {
                t = StringUtil.typeMapping(tableInfo.getDataType());
            }
        }

        stringBuffer.append(
                "package " + basePackage_.replaceAll("\\\\", ".") + "controller;\n" +
                        "\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "entity." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + ";\n" +
                        "import " + basePackage_.replaceAll("\\\\", ".") + "service." + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Service;\n" +
                        "import org.springframework.beans.factory.annotation.Autowired;\n" +
                        "import org.springframework.web.bind.annotation.*;\n" +
                        "\n"
        );

        stringBuffer = ControllerBody.getControllerRely(stringBuffer);

        stringBuffer.append(
                "@RestController\n" +
                         "@RequestMapping(\"/" + StringUtil.camelCaseName(tableName) + "\")\n" +
                "public class " + StringUtil.captureName(StringUtil.camelCaseName(tableName)) + "Controller" + " {" + "\n"
        );

        stringBuffer = ControllerBody.getControllerBody(stringBuffer,tableName);
        stringBuffer.append("\n");
        stringBuffer.append("}");
        FileUtil.fileWriter(file, stringBuffer);
    }

    /**
     * 获取表结构信息
     */
    private List<TableInfo> getTableInfo() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TableInfo> list = new ArrayList<>();
        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "select column_name,data_type,column_comment,column_key,extra from information_schema.columns where table_name=? and table_schema=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, tableName);
            ps.setString(2,sqlRepository);
            rs = ps.executeQuery();
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                //列名，全部转为小写
                tableInfo.setColumnName(rs.getString("column_name").toLowerCase());
                //列类型
                tableInfo.setDataType(rs.getString("data_type"));
                //列注释
                tableInfo.setColumnComment(rs.getString("column_comment"));
                //主键
                tableInfo.setColumnKey(rs.getString("column_key"));
                //主键类型
                tableInfo.setExtra(rs.getString("extra"));
                list.add(tableInfo);
            }
        } catch (SQLException e) {
            //输出到日志文件中
            log.error(e.getMessage());
        } finally {
            assert rs != null;
            DBConnectionUtil.close(conn, ps, rs);
        }
        return list;
    }

    /**
     * 快速创建，供外部调用，调用之前先设置一下项目的基础路径
     */
    private String create() {
        List<TableInfo> tableInfo = getTableInfo();
//        createEntity(tableInfo);
//        createRepository(tableInfo);
//        createService(tableInfo);
        createController(tableInfo);
        System.out.println("生成路径位置：" + basePath);
        return tableName + " 后台代码生成完毕！";
    }

    public static void main(String[] args) {
        //table是表名
        Scanner scanner = new Scanner(System.in);
        Scanner tableNum = new Scanner(System.in);
        System.out.println("请输入要自动生成的表的数目： ");
        int n = tableNum.nextInt();
        String[] tables = new String[n];
        System.out.println("请以”表名“+换行的格式输入要生成的表名：");
        for (int i = 0; i < n; i++) {
            String content = scanner.nextLine();
            tables[i] = content;
        }
        tableNum.close();
        scanner.close();

        for (String table : tables) {
            //依次将表名传入
            String msg = new CodeDOM(table).create();
            System.out.println(msg);
        }
    }

}
