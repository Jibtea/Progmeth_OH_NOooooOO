package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import logic.compute.ProcessUnit;

public class CalculationTask extends Task implements Computable ,Modifiable{
	
	public CalculationTask(String name, double workload) {
		super(name,workload);
	}
	
	public double compute(ProcessUnit processUnit) {
		///
		//return processUnit.compute(this);
		return processUnit.compute(this);

	}
	
	public void changeWorkload(int workload) {
		this.setWorkload(workload+this.getWorkload());
	}
	
	public void modify(int workload) {
		this.changeWorkload(workload);
	}
	
	public String fullTaskName() {
		return "Calculation Task";
	}
}
