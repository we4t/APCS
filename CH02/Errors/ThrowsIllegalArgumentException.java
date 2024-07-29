class ThrowsIllegalArgumentException {
    static int radius = 0;
    public static void main(String[] args) {
        setRadius(-1);
    }

    public static void setRadius(int newRadius) {
        if (newRadius < 0)
            throw new IllegalArgumentException("Radius cannot be negative");
        else
            radius = newRadius;
    }

}