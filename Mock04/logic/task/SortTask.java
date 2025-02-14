package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;

public class SortTask extends Task implements Computable,Parallelizable,Modifiable {

	public SortTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}

	public double compute(ProcessUnit processUnit) {
		////
		return processUnit.compute(this);
	}
	
	public double parallelCompute(ProcessUnit processUnit) {
		return processUnit.parallelCompute(this);
	}
	
	public void mergeTask(int index) {
		Task selectTask = TaskList.getTask(index);
		if(selectTask instanceof SortTask) {
			this.setWorkload(selectTask.getWorkload()+this.getWorkload());
			TaskList.removeTask(index);
		}
	}
	
	public void modify(int workload) {
		this.mergeTask(workload);
	}
	
	public String fullTaskName() {
		return "Sorting Task";
	}
}
