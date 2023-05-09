
import java.util.ArrayList;

/**
 *
 * @author Van Minh Tuan
 */
public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    private boolean isCodeDupplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent() {
        String newCode, newName;
        int newMark;

        boolean codeDupplicated = false;
        do {
            newCode = Inputter.inputPattern("St. code S000: ", "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(newCode);
            if (codeDupplicated) {
                System.out.println("Code is dupplicated!");
            }
        } while (codeDupplicated);

        newName = Inputter.inputNonBlankStr("Name of student: ");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);

        Student s = new Student(newCode, newName, newMark);
        this.add(s);
        System.out.println("Student " + newCode + " has been added");
    }

    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed!");
        } else {
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student s = this.search(sCode);
            if (s == null) {
                System.out.println("Student " + sCode + "does not existed!");
            } else {
                System.out.println("Found: " + s);
            }
        }
    }

    public void updateStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uCode = Inputter.inputStr("Input code of updated student: ");
            Student s = this.search(uCode);
            if (s == null) {
                System.out.println("Student " + uCode + "does not existed!");
            } else {
                String oldName = s.getName();
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNonBlankStr(msg);
                s.setName(newName);
                int oldMark = s.getMark();
                msg = "Old mark: " + oldMark + ", new mark 1..10: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                s.setMark(newMark);
                System.out.println("Student " + uCode + "has been updated.");
            }
        }
    }

    public void removeStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No remove can be performed!");
        } else {
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student s = this.search(rCode);
            if (s == null) {
                System.out.println("Student " + rCode + "does not existed!");
            } else {
                this.remove(s);
                System.out.println("Student " + rCode + " has been removed.");
            }
        }
    }

    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Student list:");
            for (Student s : this) {
                System.out.println(s);
            }
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }
}
