package dict;

/**
 * <p> 类描述: TODO
 *
 * @author liqinghui
 * @version TODO
 * @date 2019/02/26 17:12
 * @since 2019/02/26 17:12
 */
public final class Dictionary {
    public static class Common {
        public enum enable {
            AVAILABLE(1, "停用"), UNAVAILABLE(2, "启用");
            private int code;
            private String name;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private enable(int code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (enable e : enable.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static enable enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (enable e : enable.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }

        public enum Staff {
            CCSYSTEM(0, "ccsystem");
            private int code;
            private String name;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private Staff(int code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (Staff e : Staff.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static Staff enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (Staff e : Staff.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }
    }

    public static class Blacklist {
        public enum Purpose {
            WHITE(2, "白名单"), BLACK(1, "黑名单");
            private int code;
            private String name;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private Purpose(int code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (Purpose e : Purpose.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static Purpose enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (Purpose e : Purpose.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }

        public enum Direction {
            IN(1, "呼入"), BOTH(0, "双向"), OUT(2, "呼出");
            private int code;
            private String name;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private Direction(int code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (Direction e : Direction.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static Direction enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (Direction e : Direction.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }

        public enum Source {
            OTHER(2, "其它"), BATCH(3, "批量导入"), MANUAL(1, "话务员录入");
            private int code;
            private String name;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private Source(int code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (Source e : Source.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static Source enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (Source e : Source.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }
    }

    public static class Binary {
        public enum Bool {
            TRUE("true", "真"), FALSE("false", "假");
            private String code;
            private String name;

            public String getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private Bool(String code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (Bool e : Bool.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static Bool enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (Bool e : Bool.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }

        public enum ONOFF {
            OFF("off", "关闭"), ON("on", "开启");
            private String code;
            private String name;

            public String getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private ONOFF(String code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (ONOFF e : ONOFF.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static ONOFF enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (ONOFF e : ONOFF.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }

        public enum YESNO {
            NO("no", "否"), YES("yes", "是");
            private String code;
            private String name;

            public String getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            private YESNO(String code, String name) {
                this.code = code;
                this.name = name;
            }

            public static boolean exists(Object codeOrName, boolean codeTrueNamefalse) {
                for (YESNO e : YESNO.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return true;
                    } else {
                        if (e.getName().equals(codeOrName)) return true;
                    }
                }
                return false;
            }

            public static boolean exists(Object code) {
                return exists(code, true);
            }

            public static YESNO enumify(Object codeOrName, boolean codeTrueNamefalse) {
                for (YESNO e : YESNO.values()) {
                    if (codeTrueNamefalse) {
                        if (String.valueOf(e.getCode()).equals(String.valueOf(codeOrName))) return e;
                    } else {
                        if (e.getName().equals(codeOrName)) return e;
                    }
                }
                throw new IllegalArgumentException();
            }
        }
    }
}

