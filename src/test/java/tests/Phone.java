package tests;

import studyMate.Group;

public class Phone {
    public static void main(String[] args) {
        Group group=new Group();
        group.groupName="Batch 1";
        group.gradationDate="May";
        group.description="the group for the first batch";
        group.image="some picture";

     /*
     Json format:
     "group":{
     "groupName":"Batch 1",
     "graduationDate":"May",
     "description":"the group for the first batch",
     "image":"some picture"
     }
     */

        
    }
}
