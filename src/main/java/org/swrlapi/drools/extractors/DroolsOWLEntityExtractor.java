package org.swrlapi.drools.extractors;

import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.swrlapi.bridge.extractors.TargetRuleEngineExtractor;
import org.swrlapi.drools.owl.properties.AP;
import org.swrlapi.drools.owl.core.C;
import org.swrlapi.drools.owl.core.D;
import org.swrlapi.drools.owl.properties.DP;
import org.swrlapi.drools.owl.core.I;
import org.swrlapi.drools.owl.properties.OP;
import org.swrlapi.exceptions.TargetSWRLRuleEngineException;

/**
 * This interface describes methods for converting the Drools representation of OWL entities to their OWLAPI
 * representation.
 *
 * @see org.semanticweb.owlapi.model.OWLEntity
 * @see org.swrlapi.drools.owl.core.OE
 * @see org.swrlapi.drools.extractors.DefaultDroolsOWLEntityExtractor
 */
public interface DroolsOWLEntityExtractor extends TargetRuleEngineExtractor
{
	OWLClass extract(C c) throws TargetSWRLRuleEngineException;

	OWLNamedIndividual extract(I i) throws TargetSWRLRuleEngineException;

	OWLObjectProperty extract(OP p) throws TargetSWRLRuleEngineException;

	OWLDataProperty extract(DP p) throws TargetSWRLRuleEngineException;

	OWLAnnotationProperty extract(AP p) throws TargetSWRLRuleEngineException;

	OWLDatatype extract(D d) throws TargetSWRLRuleEngineException;
}
