package com.example.teachertinder;

public class TeacherProfile {

    private String fullName;
    private int yearsOfExperience;
    private String[] subjectsTaught;
    private String preferredRegion;
    private String[] certificatesObtained;
    private String bio;

    // TODO: implement a builder design pattern instead.
    public TeacherProfile(String fullName, int yearsOfExperience, String[] subjectsTaught,
                          String preferredRegion, String[] certificatesObtained, String bio) {
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.subjectsTaught = subjectsTaught;
        this.preferredRegion = preferredRegion;
        this.certificatesObtained = certificatesObtained;
        this.bio = bio;
    }
}
