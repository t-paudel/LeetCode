package theory.designPatterns.behavioural.command;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[6];
        offCommands = new Command[6];
        Command noCommand = new NoCommand();
        for(int i=0;i<6;i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------------Remote Control------------\n");
        for(int i=0;i<onCommands.length;i++)
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "\t" + offCommands[i].getClass().getName()+"\n");

        return sb.toString();
    }
}
