import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Staff[] staff = new Staff[2];
        staff[0] = new Staff("Thang", "0335428587", "Ha Noi");
        staff[1] = new Staff("Tu", "0987654321", "Ha Noi");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Quan ly nhan vien");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Hien thi nhan vien");
            System.out.println("4. Sua nhan vien");
            int number = scanner.nextInt();


            switch (number) {
                case 1:
                    staff = addNhanVien(staff);
                    break;
                case 2:
                    staff = delete(staff);
                    break;
                case 3:
                    display(staff);
                    break;
                case 4:
                    staff = edit(staff);
            }
        }
    }

    public static Staff[] addNhanVien(Staff[] staff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap so dien thoai: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String address = scanner.nextLine();

        Staff[] newStaff = new Staff[staff.length + 1];
        for (int i = 0; i < staff.length; i++) {
            newStaff[i] = staff[i];
        }

        Staff NV = new Staff(name, phoneNumber, address);
        newStaff[newStaff.length - 1] = NV;
        return newStaff;
    }

    public static void display(Staff[] staff) {
        for (Staff a : staff) {
            System.out.println(a.toString());
        }
    }

    public static Staff[] delete(Staff[] staff) {
        Scanner delete = new Scanner(System.in);
        System.out.println("Nhap id muon xoa");
        int id = delete.nextInt();

        int index = -1;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getId()==id){
                index=i;
            }
        }

        Staff[] newStaff = new Staff[staff.length - 1];
        for (int i = 0; i < staff.length - 1; i++) {
            if (i < index) {
                newStaff[i] = staff[i];
            } else {
                newStaff[i] = staff[i + 1];
            }
        }
        return newStaff;
    }

    public static Staff[] edit(Staff[] staff){
        Scanner delete = new Scanner(System.in);
        System.out.println("Nhap id muon sua");
        int id = delete.nextInt();

        int index = -1;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getId()==id){
                index=i;
            }
        }

        System.out.println("Nhap name");
        String name = delete.next();
        staff[index].setName(name);
        System.out.println("Nhap so dien thoai");
        String phoneNumber = delete.next();
        staff[index].setPhoneNumber(phoneNumber);
        System.out.println("Nhap dia chi");
        String address = delete.next();
        staff[index].setAddress(address);

        return staff;
    }
}
