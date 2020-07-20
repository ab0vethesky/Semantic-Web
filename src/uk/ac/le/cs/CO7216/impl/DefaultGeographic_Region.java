package uk.ac.le.cs.CO7216.impl;

import uk.ac.le.cs.CO7216.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultGeographic_Region <br>
 * @version generated on Fri Apr 29 11:51:19 WAT 2016 by Tara
 */
public class DefaultGeographic_Region extends WrappedIndividualImpl implements Geographic_Region {

    public DefaultGeographic_Region(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#contains
     */
     
    public Collection<? extends Country> getContains() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                               DefaultCountry.class);
    }

    public boolean hasContains() {
	   return !getContains().isEmpty();
    }

    public void addContains(Country newContains) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                       newContains);
    }

    public void removeContains(Country oldContains) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONTAINS,
                                          oldContains);
    }


}