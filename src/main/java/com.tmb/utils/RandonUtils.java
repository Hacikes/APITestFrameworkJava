// Использование Faker выносится в отдельный класс, для того, чтобы избежать проблем, когда разрабы Faker изменят
// Синтаксис. И для того, чтобы потом не менять его в нескольких местах, достаточно будет одного изменения в этом классе

// Бизнес уровень

package com.tmb.utils;

public final class RandonUtils {
    // В этом классе генерируются id, имя
    private RandonUtils(){}

    public static int getId(){
        return FakerUtils.getNumber(1000,2000);
    }

    public static String getFirstName(){
        return FakerUtils.getFirstName().toLowerCase();
    }

    public static String getLastName(){
        return FakerUtils.getLastName().toLowerCase();
    }
}
