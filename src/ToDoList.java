import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ToDoList extends ToDoListManager
{
    private ToDoList toDoList;
    private DefaultListModel<String> listModel;

    public void ToDoListManager()
    {
        toDoList = new ToDoList();
        JFrame frame = new JFrame("To-Do List Manager");
        listModel = new DefaultListModel<>();

        JList<String> taskList = new JList<>(listModel);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JTextField taskInput = new JTextField();

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    toDoList.addTask(task);
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0)
                {
                    toDoList.removeTask(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });

        frame.add(taskInput);
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(taskList);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ToDoListManager();
            }
        });
    }
}

