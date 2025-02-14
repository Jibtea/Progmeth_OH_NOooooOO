package logic.task;

import interfaces.Computable;
import interfaces.Duplicatable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;

public class RenderTask extends Task implements Computable,Parallelizable,Duplicatable {

	public RenderTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}
	
	public double compute(ProcessUnit processUnit) {
		return processUnit.compute(this);
	}
	
	public double parallelCompute (ProcessUnit processUnit) {
		return processUnit.parallelCompute(this);
	}
	
	public void duplicateTask(int taskNumber) {
		for (int i = 1; i <= taskNumber; i++) {
	        String taskName = this.getName() + "-" + i; // ชื่อใหม่ของ Task
	        RenderTask renderTask = new RenderTask(taskName, this.getWorkload()); // สร้าง RenderTask
	        TaskList.addTasks(renderTask); // เพิ่มลงใน TaskList
	    }
				
	}
	
	public String fullTaskName() {
		return "Rendering Task";
	}
	
}
