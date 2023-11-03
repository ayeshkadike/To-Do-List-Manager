import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;

public class ToDoListManager {
    private final ArrayList<String> tasks;
    private final DefaultListModel<String> listModel;

    public ToDoListManager() {
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();

        JFrame frame = new JFrame("To-Do List Manager");

        // Set the background color to black
        frame.getContentPane().setBackground(Color.BLACK);

        JList<String> taskList = new JList<>(listModel);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JTextField taskInput = new JTextField();

        addButton.addActionListener(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                addTask(task);
                taskInput.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0) {
                removeTask(selectedIndex);
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

    public void addTask(String task) {
        tasks.add(task);
        listModel.addElement(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            listModel.remove(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Use a custom look and feel to style the GUI
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new ToDoListManager();
            }
        });
    }
}
