package org.swrlapi.drools.owl.axioms;

import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.swrlapi.drools.extractors.DroolsA2OWLAxiomExtractor;
import org.swrlapi.drools.owl.entities.OP;
import org.swrlapi.exceptions.TargetRuleEngineException;

/**
 * Class representing an OWL transitive object property axiom in Drools.
 */
public class TPA extends UnaryObjectPropertyAxiom
{
	public TPA(OP p)
	{
		super(p);
	}

	public TPA(String propertyID)
	{
		super(new OP(propertyID));
	}

	@Override
	public String toString()
	{
		return "TPA" + super.toString();
	}

	@Override
	public OWLTransitiveObjectPropertyAxiom extract(DroolsA2OWLAxiomExtractor extractor) throws TargetRuleEngineException
	{
		return extractor.extract(this);
	}
}