package com.sjzxy.fwpt.util.codeAuto;

public class ControllerBody {

    static StringBuffer getControllerBody(StringBuffer stringBuffer,String tableName){

        String tableName1 = StringUtil.captureName(StringUtil.camelCaseName(tableName));
        String tableName2 = StringUtil.camelCaseName(tableName);

        stringBuffer.append(
                "\n" +
                "    @Autowired\n" +
                "    private " + tableName1 + "Service " + tableName2 + "Service;\n"
        );

        stringBuffer.append(
                "\n"+
                        "    @ApiOperation(value = \"添加数据\")\n" +
                        "    @PostMapping\n" +
                        "    @ApiResponse(code = 200, message = \"ok\", response = BaseResponse.class)\n" +
                        "    public BaseResponse add" + tableName1 + "(@ApiParam(\"实体对象\") @Valid @RequestBody "+ tableName1 +" "+ tableName2 +"){\n" +
                        "        "+ tableName1 +" obj = "+ tableName2 +"Service.add" + tableName1+"("+ tableName2 +");\n" +
                        "        if (Objects.isNull(obj)){\n" +
                        "            throw new BusinessException(ResultCodeEnum.AddDataError);\n" +
                        "        }\n" +
                        "        return BaseResponse.ok().data(obj);\n" +
                        "    }\n" +
                        "\n" +
                        "    @ApiOperation(value = \"根据id删除数据\")\n" +
                        "    @DeleteMapping(\"/del/{id}\")\n" +
                        "    public BaseResponse del" + tableName1 + "(@PathVariable int id){\n" +
                        "        " + tableName2 + "Service.del"+tableName1+"(id);\n" +
                        "        return BaseResponse.ok();\n" +
                        "    }\n" +
                        "\n" +
                        "    @ApiOperation(value = \"更新数据\")\n" +
                        "    @PutMapping\n" +
                        "    public BaseResponse update" + tableName1 + "(@RequestBody "+ tableName1 + " "+tableName2+"){\n" +
                        "        " + tableName1 + " obj = "+tableName2+"Service.update" + tableName1 + "("+tableName2+");\n" +
                        "        if (Objects.isNull(obj)){\n" +
                        "            throw new BusinessException(ResultCodeEnum.UpdateDataError);\n" +
                        "        }\n" +
                        "        return BaseResponse.ok().data(obj);\n" +
                        "    }\n" +
                        "\n" +
                        "    @ApiOperation(value = \"查询全部数据\")\n" +
                        "    @GetMapping(\"/datas\")" +
                        "    public BaseResponse findAll" + tableName1 + "(){\n" +
                        "        List<"+tableName1+"> lists = "+tableName2+"Service.findAll"+tableName1+"();\n" +
                        "        return BaseResponse.ok().data(lists);\n" +
                        "\n" +
                        "    }"
        );
        return stringBuffer;
    }

    public static StringBuffer getControllerRely(StringBuffer stringBuffer) {
        return stringBuffer.append(
                "import io.swagger.annotations.ApiOperation;\n" +
                        "import io.swagger.annotations.ApiResponse;\n" +
                        "import com.sjzxy.fwpt.common.response.BaseResponse;\n" +
                        "import io.swagger.annotations.ApiParam;\n" +
                        "import javax.validation.Valid;\n" +
                        "import java.util.Date;\n" +
                        "import java.util.List;\n" +
                        "import java.util.Objects;\n" +
                        "import com.sjzxy.fwpt.common.exception.BusinessException;\n" +
                        "import com.sjzxy.fwpt.common.enums.ResultCodeEnum;\n" + "\n"
        );
    }
}
