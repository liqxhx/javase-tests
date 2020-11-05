package dict;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p> 类描述: 字典枚举生成工具类
 *
 * <p> 根据{@link Dict}列表来生成
 * @author liqinghui
 * @version 1.0
 * @since 1.0
 * @date 2019/02/26 16:40
 */
public final class DictionaryGenerator {

    public static String gen( List<Dict> list) {

        Map<String, Object> top = mapify(list);

        StringBuffer stringBuffer = new StringBuffer("public final class Dictionary {").append(System.lineSeparator());

        top.entrySet().forEach(topEntry -> {
            stringBuffer.append("\t").append("public static class ").append(iscommon(topEntry.getKey()) ? "Common": topEntry.getKey()).append(" {").append(System.lineSeparator());;

            Optional.ofNullable(topEntry.getValue()).ifPresent(domainValue -> {

                Map<String, Object> typeMap = (HashMap<String, Object>)domainValue;

                typeMap.entrySet().forEach(typeEntry -> {

                    stringBuffer.append("\t\t").append("public enum ").append(typeEntry.getKey()).append(" {").append(System.lineSeparator());

                    Optional.ofNullable(typeEntry.getValue()).ifPresent(typeValue -> {

                        Map<String, Object> labelMap = (HashMap<String, Object>)typeValue;

                        final TypeWrapper valueType = new TypeWrapper();

                        labelMap.entrySet().forEach(labelEntry -> {

                            stringBuffer.append("\t\t\t").append(labelEntry.getKey()).append("(");

                            Optional.ofNullable(labelEntry.getValue()).ifPresent(labeValue -> {

                                Map<String, String> itemMap = (HashMap)labeValue;
                                valueType.type = getType(itemMap.get("value"));

                                boolean quote = "String".equalsIgnoreCase(valueType.type);

                                stringBuffer.append(quote?"\"": "").append(itemMap.get("value")).append(quote?"\"": "").append(",\"").append(itemMap.get("name")).append("\"");

                            });

                            stringBuffer.append(")").append(",");

                        });
                        stringBuffer.deleteCharAt(stringBuffer.length()-1);

                        stringBuffer.append(";private ").append(valueType.type).append(" code; private String name;");
                        stringBuffer.append("public ").append(valueType.type).append(" getCode(){return this.code;} public String getName(){return this.name;}");
                        stringBuffer.append("private ").append(typeEntry.getKey()).append("(").append(valueType.type).append(" code, String name){this.code = code;this.name=name;}");
                        stringBuffer.append("public static boolean exists(Object codeOrName, boolean codeTrueNamefalse)")
                                .append("{for(").append(typeEntry.getKey()).append(" e : ").append(typeEntry.getKey()).append(".values()").append("){")
                                .append("if(codeTrueNamefalse) { if(String.valueOf(e.getCode()).equals(String.valueOf(codeOrName)))")
                                .append("return true;")
                                .append("} else {")
                                .append("if(e.getName().equals(codeOrName)) return true;")
                                .append("}")

                                .append("}")
                                .append("return false;")
                                .append("}");


                        stringBuffer.append("public static boolean exists(Object code)")
                                .append("{")
                                .append("return exists(code, true);")
                                .append("}");

                        stringBuffer.append("public static ").append(typeEntry.getKey()).append(" enumify(Object codeOrName, boolean codeTrueNamefalse)")
                                .append("{for(").append(typeEntry.getKey()).append(" e : ").append(typeEntry.getKey()).append(".values()").append("){")
                                .append("if(codeTrueNamefalse) { if(String.valueOf(e.getCode()).equals(String.valueOf(codeOrName)))")
                                .append("return e;")
                                .append("} else {")
                                .append("if(e.getName().equals(codeOrName)) return e;")
                                .append("}")

                                .append("}")
                                .append("throw new IllegalArgumentException();")
                                .append("}");
                    });

                    stringBuffer.append("\t\t").append("}").append(System.lineSeparator());

                });

            });

            stringBuffer.append("\t").append("}").append(System.lineSeparator());

        });



        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public static Map<String, Object> mapify(List<Dict> list) {
        Map<String, Object> top = new HashMap<String, Object>();

        list.stream().forEach(dict -> {
            Object lel1 = top.get(dict.getDomain());
            if(lel1 == null) {
                lel1 = new HashMap<>();
                top.put(dict.getDomain(), lel1);
            }

            Map domain = (HashMap)lel1;
            Object lel2 =domain.get(dict.getType());
            if(lel2 == null) {
                lel2 = new HashMap<>();
                domain.put(dict.getType(), lel2);
            }

            Map type = (HashMap)lel2;
            Object lel3 = type.get(dict.getLabel());
            if(lel3 == null) {
                lel3 = new HashMap<>();
            }

            Map item = (Map<String,Object>)lel3;
            item.put("id", dict.getId());
            item.put("pid", dict.getPid());
            item.put("domain", dict.getDomain());
            item.put("type", dict.getType());
            item.put("value", dict.getValue());
            item.put("name", dict.getName());
//           item.put("enable", dict.getEnable());
            item.put("label", dict.getLabel());


            type.put(dict.getLabel(), item);
        });

        return top;
    }

    private static String getType(String value) {
        return StringUtils.isNumeric(value) ? "int" : "String";
    }

    private static boolean iscommon(String key) {
        return key == null || "".equals(key.trim()) || "*".equals(key.trim());
    }

    private static class TypeWrapper {
        public String type = "int";
    }

}
