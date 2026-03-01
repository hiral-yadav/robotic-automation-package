    public enum PackageType {
        BULKY_AND_HEAVY_PACKAGE ("REJECTED"),
        BULKY_OR_HEAVY_PACKAGE("SPECIAL"),
        STANDARD_PACKAGE("STANDARD");

        private String dispatchStack;

        private PackageType(String dispatchStack) {
            this.dispatchStack = dispatchStack;
        }

        public String getDispatchStack() {
            return dispatchStack;
        }
    }