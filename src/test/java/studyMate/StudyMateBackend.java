package studyMate;

import java.util.ArrayList;
import java.util.List;

public class StudyMateBackend {
    private List<Group> groups=new ArrayList<>();
    private  List <Student> students=new ArrayList<>();

    //CRUD for group
    public void createGroup(Group group){
        if(group.groupName.isEmpty()){
            System.out.println("Status: DENIED");
            System.out.println("Group name can not be empty");
        }else{
            System.out.println("Status: SUCCESS");
            System.out.println("Group is created");
            groups.add(group);
        }
    }


    public List<Group> getGroups(){
        System.out.println("Status: SUCCESS");
        return groups;
    }

    public void updateGroup(Group existingGroup, Group newGroup){
        int index= groups.indexOf(existingGroup);
        groups.remove(existingGroup);
        groups.add(index,newGroup);
        System.out.println("Status: SUCCESS");
        System.out.println("Group is updated");
    }
    public  void deleteGroup(Group group){
        groups.remove(group);
        System.out.println("Status: SUCCESS");
        System.out.println("Group deleted");
    }



}
