package name.caiyao.gavatar;

/**
 * Created by 蔡小木 on 2016/12/14 0014.
 */

public enum Gender {
    MALE("male"), FEMALE("female");

    private String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

    public String getGenderName() {
        return this.genderName;
    }
}
