
/**
 *
 * @author Van Minh Tuan
 */
public class StudentManeger {
    public static void main(String[] args) {
        
        String[] options = {"Add new student", "Search a student", "Update name and mark", "Remove a student", "List all student(s)", "Quit"};
        int choice = 0;
        StudentList list = new StudentList();
        
        do {            
            System.out.println();
            System.out.println("              ------------------------");
            System.out.println("            [ STUDENT MANAGING PROGRAM ]");
            System.out.println("              ------------------------");
            System.out.println();
            choice  = Menu.getChoice(options);
            switch (choice) {
                case 1: list.addStudent();
                break;
                case 2: list.searchStudent();
                break;
                case 3: list.updateStudent();
                break;
                case 4: list.removeStudent();
                break;
                case 5: list.printAll();
                break;
                default:
                    System.out.println();
                    System.out.println("              THANK YOU FOR USING");
            }
        } while (choice > 0 && choice < 6);
    }
}
