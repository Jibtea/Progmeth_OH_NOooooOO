package logic.task;

import java.util.ArrayList;
import java.util.Iterator;

import interfaces.Computable;
import interfaces.Duplicatable;
import interfaces.Modifiable;
import interfaces.Parallelizable;

public class TaskManager extends Task  {
	public static ArrayList<Task> getTaskByType(ArrayList<Class> types) {
		// TODO implement this method
		ArrayList<Task> tasks = TaskList.getTasks();
		ArrayList<Task> returnTasks = new ArrayList<Task>();

		for (Task task : tasks) {
            for (Class type : types) {
                if (type.isAssignableFrom(task.getClass())) {
                    returnTasks.add(task);
                    break; // หากตรงเงื่อนไขแล้วให้หยุดตรวจสอบประเภทอื่น
                }
            }
        }
		return returnTasks;
	}

	public static void deleteDuplicateTasks() {
		// TODO implement this method
		ArrayList<Task> tasks = TaskList.getTasks();  // ดึง tasks ออกมา
        Iterator<Task> iterator = tasks.iterator();

        // วนลูปตรวจสอบ task แต่ละตัว
        while (iterator.hasNext()) {
            Task task = iterator.next();
            
            // ตรวจสอบว่า task สามารถทำซ้ำได้และมี "-" ในชื่อ
            if (task instanceof Duplicatable && task.toString().contains("-")) {
                iterator.remove();  // ลบ task ออกจาก tasks
            }
        }
		///
	}

	public static boolean instanceOf(Class checkClass, Class interfaceClass) {
		return interfaceClass.isAssignableFrom(checkClass);
	}
}
