package epam_03.CleanCode;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Interest
{
	double principle;
	double rateOfInterest;
	double timePeriod;
	Interest(double principle,double rateOfInterest,double timePeriod)
	{
		 this.principle=principle;
		 this.rateOfInterest=rateOfInterest;
		 this.timePeriod=timePeriod;
	}
	double simpleInterest()
	{
		return (principle*rateOfInterest*timePeriod)/100;
	}
	double compoundInterest()
	{
		return principle*Math.pow((1+(rateOfInterest/100)),timePeriod);
	}
}
class HouseConstructionCost
{
	String materialStandard;
	double totalArea;
	boolean automatedHome;
	HouseConstructionCost(String materialStandard,double totalArea,boolean automatedHome)
	{
		this.materialStandard=materialStandard;
		this.totalArea=totalArea;
		this.automatedHome=automatedHome;
	}
	double totalConstructionCost()
	{
		double totalCost=0.0;
		if(materialStandard.equals("standard"))
		{
			totalCost=1200*totalArea;		
		}
		else if(materialStandard.equals("abovestandard"))
		{
			totalCost=1500*totalArea;
		} 
		else if(materialStandard.equals("highstandard"))
		{
			if(automatedHome==true)
				totalCost=2500*totalArea;
			else
				totalCost=1800*totalArea;
		}
		return totalCost;
			
	}
}
public class App 
{
    public static void main( String[] args ) throws IOException 
    {
    	Scanner scan = new Scanner(System.in);
    	OutputStreamWriter O = new OutputStreamWriter(System.out);
    	double principle,rateOfInterest,timePeriod,totalAmount,totalArea,interestCalculated,totalHouseCost;
    	int choice;
    	char choiceAtEnd;
    	boolean automatedHome;
    	
    	String materialStandard;
    	do
    	{
    	    O.write("\n1.Calculation of Interest");
    		O.flush();
    		O.write("\n2.House Construction Cost");
    		O.flush();
    		O.write("\n Enter your choice: ");
    		O.flush();
    		choice=scan.nextInt();
    		
    		switch(choice)
    		{
    			case 1: O.write("\n Enter the principle Amount:");
    					O.flush();
    					principle = scanner.nextDouble();
    					O.write("\n Enter  Rate of Interest per annum:");
    					O.flush();
    					rateOfInterest = scanner.nextDouble();
    					O.write("\n Enter  Time period( in years):");
    					O.flush();
    					timePeriod = scanner.nextDouble();
    					Interest interest = new Interest(principle,rateOfInterest,timePeriod);
    					O.write("\n 1.Simple Interest");
    					O.flush();
    					O.write("\n 2.Compound Interest");
    					O.flush();
    					O.write("\n Enter your choice:");
    					O.flush();
    					choice = scan.nextInt();
    					switch(choice)
    					{
        	    			case 1: interestCalculated = interest.simpleInterest();
        	    					totalAmount=principle+interestCalculated;
        	    					O.write("\n Simple Interest : " + interestCalculated);
        	    					O.flush();
        	    					O.write("\n Total Amount Recieved : " + totalAmount);
        	    					O.flush();
        	    					break;
        	    			case 2: interestCalculated = interest.compoundInterest();
        	    					totalAmount=interestCalculated;
        	    					interestCalculated=interestCalculated-principle;
        	    					O.write("\n Compound Interest : " + interestCalculated);
        	    					O.flush();
        	    					O.write("\n Total Amount Recieved: " + totalAmount);
        	    					O.flush();
        	    					break;
        	    			default:O.write("\n Wrong Choice");
								 	O.flush();
								 	break;	
    					}
    					break;
    			case 2: O.write("\n Total Construction Cost Calculation:");
    					O.flush();
    					scan.nextLine();
    					O.write("\n Enter the Material Standard(standard/abovestandard/highstandard):");
    					O.flush();
    					materialStandard = scan.nextLine();
    					O.write("\n Enter the total Area of the house:");
    					O.flush();
    					totalArea = scan.nextDouble();
    				    automatedHome=false;
    					if(materialStandard.equals("highstandard"))
    					{
    						O.write("\n Do you want to have auotmated house(true/false)?");
    						O.flush();
    						automatedHome=scan.hasNextBoolean();
    					}
    					HouseConstructionCost house = new HouseConstructionCost(materialStandard,totalArea,automatedHome);
    					totalHouseCost=house.totalConstructionCost();
    					O.write("\n Total Construction Cost :" + totalHouseCost);
    					O.flush();
    					break;
    			default:O.write("\n Wrong Choice");
						O.flush();
						break;
    		}
    		O.write("\n Do you want to continue?");
    		O.flush();
    		scan.nextLine();
    		choiceAtEnd = scan.next().charAt(0);
    		}while(choiceAtEnd!='n' && choiceAtEnd!='N');
    		scan.close();	
    }
}














































































