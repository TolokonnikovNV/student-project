public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Alex";
        so.hLastName = "Petrov";
        so.wFirstName = "Galina";
        so.wLastName = "Petrova";

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer;
        answer = 199;
        System.out.println("saveStudentOrder: " + studentOrder.hFirstName + " " + studentOrder.hLastName + " " +
                                                  studentOrder.wFirstName + " " + studentOrder.wLastName);
        return answer;
    }
}
