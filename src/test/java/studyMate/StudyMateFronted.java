package studyMate;

import studyMate.StudyMate;

public class StudyMateFronted {
    public static void main(String[] args) {
        StudyMate codeWise=new StudyMate();
        System.out.println(codeWise.getGroups());
        codeWise.createGroup("Batch 1");
        codeWise.createGroup("Batch 2");
        codeWise.createGroup("English Online");
        System.out.println(codeWise.getGroups());




    }
}
