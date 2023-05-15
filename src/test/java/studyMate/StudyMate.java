package studyMate;

import java.util.ArrayList;
import java.util.List;

public class StudyMate {

    private List<String> groups=new ArrayList<>();

    //Business layer: API
    //User story 1: As an Admin i should be able to create a group
    //Requirements: group name can not be empty, and can not be more than 15 letters
    public void createGroup(String groupName){
        if(groupName.isEmpty()|| groupName.length()>15){
            System.out.println("Status: DENIED");
            System.out.println("Request denied : group name can not be empty or more than 15 letters");
        }else{
            System.out.println("Status: SUCCESS");
            System.out.println("Group: "+groupName+ " is created successfully");
            groups.add(groupName);
        }
    }
    //USer story 2: As an admin , I should be able to delete group

    public void deleteGroup(String groupName){
        groups.remove(groupName);
        System.out.println("Group: "+groupName+ " is deleted successfully");
    }

    //User story 3: As an admin , I should be able to edit group the existing group
    //Requirement: new group name can not be emty or more than 15 characters


    public void updateGroup(String newGroupName, String existingGroupName){
        if(newGroupName.isEmpty()|| newGroupName.length()>15){
            System.out.println("Status: DENIED \n Invalid new group name: "+newGroupName);
        }else{
            int index=groups.indexOf(existingGroupName);
            groups.remove(existingGroupName);
            groups.add(index, newGroupName);
            System.out.println("Status: SUCCESS");
            System.out.println("Group updated successfully");
        }
    }

    //User story 4: As an Admin, I should be able to get the list of groups

    public List<String> getGroups(){
        System.out.println("Status: SUCCESS");
        return groups;
    }


}
