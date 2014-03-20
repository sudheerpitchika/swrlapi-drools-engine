package org.swrlapi.drools.owl.axioms;

import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.swrlapi.drools.extractors.DroolsA2OWLAxiomExtractor;
import org.swrlapi.drools.owl.entities.DP;
import org.swrlapi.exceptions.TargetRuleEngineException;

/**
 * This class represents an OWL data property declaration axiom.
 */
public class DPDA extends DA<DP>
{
	public DPDA(String propertyID)
	{
		super(new DP(propertyID));
	}

	public DPDA(DP property)
	{
		super(property);
	}

	public DP getP()
	{
		return getE();
	}

	@Override
	public String toString()
	{
		return "DPDA" + super.toString();
	}

	@Override
	public OWLDeclarationAxiom extract(DroolsA2OWLAxiomExtractor extractor) throws TargetRuleEngineException
	{
		return extractor.extract(this);
	}
}