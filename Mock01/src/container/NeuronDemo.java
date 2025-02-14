package container;
//import container.Neuron;

//neuron.set
public class NeuronDemo {
	private Neuron n;
	
	public void demonstrate() {
		Neuron.setRangeWeight(0.1,0.7);
		double[] weightSet= {0.2,0.3,0.4};
		double bias=0.2;
		Neuron n = new Neuron(weightSet,bias);
		n.setGradient(0.6);
		n.setValue(1);
		
		/////
		
		setN(n);
	}

	public Neuron getN() {
		return n;
	}

	public void setN(Neuron n) {
		this.n = n;
	}
	
	
}
