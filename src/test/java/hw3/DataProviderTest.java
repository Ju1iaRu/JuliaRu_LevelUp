package hw3;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider(name = "SumDataProviderLong")
    public static Object[][] SumLongData() {
        return new Object[][] {
                {456789, 123456, 580245},
                {-7895643, 976453, -6919190},
                {1, -3789564, -3789563},
        };
    }

    @DataProvider(name = "SumDataProviderDouble")
    public static Object[][] SumDoubleData() {
        return new Object[][] {
                {0.7, 2.5, 3.2},
                {-6.4, 1.5, -4.9},
                {3.41, 1.59, 5},
        };
    }

    @DataProvider(name = "SubDataProviderLong")
    public static Object[][] SubLongData() {
        return new Object[][] {
                {456789, 123456, 333333},
                {-7895643, 976453, -8872096},
                {1, -3789564, 3789565},
        };
    }

    @DataProvider(name = "SubDataProviderDouble")
    public static Object[][] SubDoubleData() {
        return new Object[][] {
                {0.7, 2.5, -1.8},
                {-6.4, 1.5, -7.9},
                {3.41, 1.59, 1.82},
        };
    }

    @DataProvider (name = "MultDataProviderLong")
    public static Object[][] MultLongData() {
        return new Object[][] {
                {456789, 1237890, 565454535210L},
                {-7895643, 1, -7895643},
                {0, -3789564, 0},
        };
    }

    @DataProvider (name = "MultiDataProviderDouble")
    public static Object[][] MtplDoubleData() {
        return new Object[][] {
                {0.7, 2.5, 1},
                {-6.4, 1.5, -10},
                {0, 1.59, 0},
        };
    }

    @DataProvider (name = "DivDataProviderLong")
    public static Object[][] DivLongData() {
        return new Object[][] {
                {456789, 123456, 3},
                {-7895643, 976453, -8},
                {1, -3789564, 0},
                {0, 5654535675210L, 0},
        };
    }

    @DataProvider (name = "DivDataProviderDouble")
    public static Object[][] DivDoubleData() {
        return new Object[][] {
                {2.4, 1.5, 1.6},
                {-6.4, 3.2, -2},
                {3.41, 1, 3.41},
                {0, 7.9, 0},
        };
    }

    @DataProvider (name = "PowDataProviderDouble")
    public static Object[][] PowDoubleData() {
        return new Object[][] {
                {2.4, 1.5, 2.4},
                {2, 0, 1},
                {3.41, 1, 3.41},
                {0, 7.9, 0},
        };
    }

    @DataProvider (name = "SqrtDataProvider")
    public static Object[][] SqrtData() {
        return new Object[][] {
                {1.21, 1.1},
                {36, 6},
                {1 , 1},
        };
    }

    @DataProvider (name = "TgDataProvider")
    public static Object[][] TgData() {
        return new Object[][] {
                {Math.toRadians(45), 1},
                {Math.toRadians(180), 1},
                {Math.toRadians(60), 1},
        };
    }

    @DataProvider (name = "CtgDataProvider")
    public static Object[][] CtgData() {
        return new Object[][] {
                {Math.toRadians(45), 0.65},
                {Math.toRadians(90), 0.91},
                {Math.toRadians(60), 0.78},
        };
    }

    @DataProvider (name = "SinDataProvider")
    public static Object[][] SinData() {
        return new Object[][] {
                {Math.toRadians(30), 0.5},
                {Math.toRadians(270), -1},
                {Math.toRadians(90), 1},
        };
    }
    @DataProvider (name = "CosDataProvider")
    public static Object[][] CosData() {
        return new Object[][] {
                {Math.toRadians(60), 0.86},
                {Math.toRadians(180), 1.22},
                {Math.toRadians(90), 1},
        };
    }


    @DataProvider (name = "PositiveDataProvider")
    public static Object[][] PositiveData() {
        return new Object[][] {
                {5776766, true},
                {-776764, false},
                {0, false}
        };
    }
    @DataProvider (name = "NegativeDataProvider")
    public static Object[][] NegativeData() {
        return new Object[][] {
                {-776764, true},
                {5776766, false},
                {0, false}
        };
    }


}
