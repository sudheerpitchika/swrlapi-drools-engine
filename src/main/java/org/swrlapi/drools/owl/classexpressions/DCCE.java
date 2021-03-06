package org.swrlapi.drools.owl.classexpressions;

import org.swrlapi.drools.owl.core.DroolsTernaryObject;

/**
 * This class represents an OWL data exact cardinality class expression in Drools.
 *
 * @see org.semanticweb.owlapi.model.OWLDataExactCardinality
 */
public class DCCE extends DroolsTernaryObject<String, String, Integer> implements CE
{
	private static final long serialVersionUID = 1L;

	public DCCE(String ceid, String propertyID, Integer card)
	{
		super(ceid, propertyID, card);
	}

	@Override
	public String getceid()
	{
		return getT1();
	}

	public String getpid()
	{
		return getT2();
	}

	public Integer getcard()
	{
		return getT3();
	}

	@Override
	public String toString()
	{
		return "DCCE" + super.toString();
	}
}
