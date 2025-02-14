package container;

import function.Function;
import util.Activation;


import util.GenRandom;

public class Layer {
	private Neuron[] neurons;
	private Function function;
	public Layer(int inNeurons, int nNeurons ,Function function) {
		setFunction(function);
		//this.neurons = neurons;
		Neuron[] neurons= new Neuron[nNeurons];
		for(int i=0;i<neurons.length;i++) {
			double[] weightSet = new double[inNeurons];
			double bias = GenRandom.randomDouble(0, 1);
			for(int j=0;j<weightSet.length;j++) {
				weightSet[j] = GenRandom.randomDouble(Neuron.getMinWeightValue(),Neuron.getMaxWeightValue() );
			}
			neurons[i] = new Neuron(weightSet,bias);
		}
		
		setNeurons(neurons);
		
		//Neuron n = new Neuron(weightSet,bias);
		
		
		
	}
	
	
	public Layer(double[] input) {
		Neuron[] neurons=new Neuron[input.length];
		
		for(int i=0;i<neurons.length;i++) {
			neurons[i]=new Neuron(input[i]);
		}
		
		setNeurons(neurons);
		setFunction(null);
	}
	
	//methods
	
	public double applyActivation(double x) {
		if(function==Function.SIGMOID) {
			return Activation.sigmoid(x);
		}
		else if(function==Function.TANH) {
			return Activation.tanh(x);
		}
		else if(function==Function.RELU) {
			return Activation.relu(x);
		}
		else {
			throw new IllegalArgumentException("Unknown activation function: " + function);
		}
	   
	}
	
	public double applyActivationDerivative(double x) {
		if(function==Function.SIGMOID) {
			return Activation.sigmoidDerivative(x);
		}
		else if(function==Function.TANH) {
			return Activation.tanhDerivative(x);
		}
		else if(function==Function.RELU) {
			return Activation.reluDerivative(x);
		}
		else {
			throw new IllegalArgumentException("Unknown activation function: " + function);
		}
	}


	
	
	///gettersetter
	public Neuron[] getNeurons() {
		return neurons;
	}


	public void setNeurons(Neuron[] neurons) {
		this.neurons = neurons;
	}


	public Function getFunction() {
		return function;
	}


	public void setFunction(Function function) {
		this.function = function;
	}
	
	
}
