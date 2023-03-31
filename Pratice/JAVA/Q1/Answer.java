//#region import
import java.util.Scanner;
//#endregion

//#region Monney class (abstract class)
abstract class Monney{
    private int monney;


    public Monney(int monney){
        this.monney = monney;
    }

    public int getMonney(){
        return this.monney;
    }

    public void setMonney(int monney){
        this.monney = monney;
    }

    abstract void monneyManagement();

}
//#endregion

//#region MonneyAdd class super : Monney
class MonneyAdd extends Monney{
    private int add;

    public MonneyAdd(int monney, int add){
        super(monney);
        this.add = add;
    }

    @Override
    void monneyManagement(){
        setMonney(getMonney() + add);;
    }
}
//#endregion

//#region MonneyUse class super : Monney
class MonneyUse extends Monney{
    private int use;

    public MonneyUse(int monney, int use){
        super(monney);
        this.use = use;
    }

    @Override
    void monneyManagement(){
        setMonney(getMonney() - use);
    }

}
//#endregion

//#region HouseholdLedger class (in main)
public class HouseholdLedger {
    static Scanner scan = new Scanner(System.in);

    void selectManagemant(Monney monney){
        if(monney instanceof MonneyAdd){
            monney.monneyManagement();
        }
        else if(monney instanceof MonneyUse){
            monney.monneyManagement();
        }
    }

    boolean choice(){
        boolean choice;
        String choiceCommand;

        System.out.println("\n설정하시겠습니까? true: t     false: [any command]");
        choiceCommand = scan.next();
        switch(choiceCommand){
            case "t" :
                choice = true;
                break;
            default :
                choice = false;
        }

        return choice;
    }

    //#region main
    public static void main(String[] args) {
        int setmonney;
        int day;
        int monneyday;

        String adduse;
        Monney[] monney = new Monney[30];
        HouseholdLedger h = new HouseholdLedger();

        System.out.print("하루에 할당할 금액을 설정해 주세요 : ");
        setmonney = scan.nextInt();

        while(true){
            
            System.out.println("---------------\n할 동작을 선택하세요. 돈 추가[add] 돈 사용[use] 탐색[search] 종료[q]\n---------------");
            adduse = scan.next();

            System.out.print("돈을 관리할 날짜를 선택 하세요 : ");
            day = scan.nextInt();

            if(adduse.equals("q")){
                break;
            }
            else if(adduse.equals("add")){
                System.out.print("추가할 돈을 입력하세요 : ");
                monneyday = scan.nextInt();

                if(h.choice()){
                    monney[day-1] = new MonneyAdd(setmonney, monneyday);
                    h.selectManagemant(monney[day-1]);
                    System.out.println("\n" + day + "일에 할당된 돈: " + monney[day-1].getMonney() + "\n");
                }
                else{
                    System.out.println("명령 취소");
                }
            }
            else if(adduse.equals("use")){
                System.out.print("사용할 돈을 입력하세요 : ");
                monneyday = scan.nextInt();

                if(h.choice()){
                    monney[day-1] = new MonneyUse(setmonney, monneyday);
                    h.selectManagemant(monney[day-1]);
                    System.out.println("\n" + day + "일에 할당된 돈: " + monney[day-1].getMonney() + "\n");
                }
                else{
                    System.out.println("명령 취소");
                }
            }
            else if(adduse.equals("search")){
                if(monney[day-1] == null){
                    System.out.println("\n" + day + "일에 할당된 돈: " + setmonney + "\n");
                }else{
                    System.out.println("\n" + day + "일에 할당된 돈: " + monney[day-1].getMonney() + "\n");
                }
            }
            else{
                System.out.println("알수없는 명령어 입니다.");
                continue;
            }
            
        }
    }
    //#endregion
}
//#endregion