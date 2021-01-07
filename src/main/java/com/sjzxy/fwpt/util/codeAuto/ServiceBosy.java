package com.sjzxy.fwpt.util.codeAuto;

public class ServiceBosy {

    public static StringBuffer getServiceBody(StringBuffer stringBuffer, String tableName) {

        String tableName1 = StringUtil.captureName(StringUtil.camelCaseName(tableName));
        String tableName2 = StringUtil.camelCaseName(tableName);

        return stringBuffer.append(
                "    @Autowired\n" +
                        "    private " + tableName1 + "Repository "+tableName2+"Repository;\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public "+tableName1+" add"+tableName1+"("+tableName1+" "+tableName2+") {\n" +
                        "        return "+tableName2+"Repository.save("+tableName2+");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void del"+tableName1+"(int id) {\n" +
                        "        "+tableName2+"Repository.deleteById((long) id);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public "+tableName1+" update"+tableName1+"("+tableName1+" "+tableName2+"){\n" +
                        "        return "+tableName2+"Repository.save("+tableName2+");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public List<"+tableName1+"> findAll"+tableName1+"() {\n" +
                        "        return "+tableName2+"Repository.findAll();\n" +
                        "    }\n"
        );

    }

    public static void getServiceImplBody(StringBuffer stringBuffer, String tableName) {

        String tableName1 = StringUtil.captureName(StringUtil.camelCaseName(tableName));
        String tableName2 = StringUtil.camelCaseName(tableName);

        stringBuffer.append(
                "    /**\n" +
                        "     * 添加数据\n" +
                        "     * @param " + tableName2 + "\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    "+tableName1+" add" + tableName1 + "("+ tableName1 +" "+tableName2+");\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 删除数据\n" +
                        "     * @param id\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    void del"+tableName1+"(int id);\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 更新数据\n" +
                        "     * @param "+tableName2+"\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    "+tableName1+" update"+tableName1+"("+tableName1+" "+tableName2+");\n" +
                        "\n" +
                        "\n" +
                        "    /**\n" +
                        "     * 查询全部数据\n" +
                        "     * @return\n" +
                        "     */\n" +
                        "    List<"+tableName1+"> findAll"+tableName1+"();"
        );
    }
}
