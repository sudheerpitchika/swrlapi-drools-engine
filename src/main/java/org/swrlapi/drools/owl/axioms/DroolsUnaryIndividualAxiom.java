package org.swrlapi.drools.owl.axioms;

import org.swrlapi.drools.owl.core.DroolsUnaryObject;

public abstract class DroolsUnaryIndividualAxiom extends DroolsUnaryObject<String> implements A
{
	public DroolsUnaryIndividualAxiom(String individualID)
	{
		super(individualID);
	}

	public String getiid()
	{
		return getT1();
	}

	@Override
	public String toString()
	{
		return super.toString();
	}
}