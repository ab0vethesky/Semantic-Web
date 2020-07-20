package uk.ac.le.cs.CO7216;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Country <br>
 * @version generated on Fri Apr 29 11:51:19 WAT 2016 by Tara
 */

public interface Country extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#has
     */
     
    /**
     * Gets all property values for the has property.<p>
     * 
     * @returns a collection of values for the has property.
     */
    Collection<? extends Yearly_GDP_Value> getHas();
    

    /**
     * Checks if the class has a has property value.<p>
     * 
     * @return true if there is a has property value.
     */
    boolean hasHas();

    /**
     * Adds a has property value.<p>
     * 
     * @param newHas the has property value to be added
     */
    void addHas(Yearly_GDP_Value newHas);

    /**
     * Removes a has property value.<p>
     * 
     * @param oldHas the has property value to be removed.
     */
    void removeHas(Yearly_GDP_Value oldHas);


    /* ***************************************************
     * Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#has_a
     */
     
    /**
     * Gets all property values for the has_a property.<p>
     * 
     * @returns a collection of values for the has_a property.
     */
    Collection<? extends WrappedIndividual> getHas_a();

    /**
     * Checks if the class has a has_a property value.<p>
     * 
     * @return true if there is a has_a property value.
     */
    boolean hasHas_a();

    /**
     * Adds a has_a property value.<p>
     * 
     * @param newHas_a the has_a property value to be added
     */
    void addHas_a(WrappedIndividual newHas_a);

    /**
     * Removes a has_a property value.<p>
     * 
     * @param oldHas_a the has_a property value to be removed.
     */
    void removeHas_a(WrappedIndividual oldHas_a);


    /* ***************************************************
     * Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#uses
     */
     
    /**
     * Gets all property values for the uses property.<p>
     * 
     * @returns a collection of values for the uses property.
     */
    Collection<? extends Official_Language> getUses();

    /**
     * Checks if the class has a uses property value.<p>
     * 
     * @return true if there is a uses property value.
     */
    boolean hasUses();

    /**
     * Adds a uses property value.<p>
     * 
     * @param newUses the uses property value to be added
     */
    void addUses(Official_Language newUses);

    /**
     * Removes a uses property value.<p>
     * 
     * @param oldUses the uses property value to be removed.
     */
    void removeUses(Official_Language oldUses);


    /* ***************************************************
     * Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#capitalCity
     */
     
    /**
     * Gets all property values for the capitalCity property.<p>
     * 
     * @returns a collection of values for the capitalCity property.
     */
    Collection<? extends String> getCapitalCity();

    /**
     * Checks if the class has a capitalCity property value.<p>
     * 
     * @return true if there is a capitalCity property value.
     */
    boolean hasCapitalCity();

    /**
     * Adds a capitalCity property value.<p>
     * 
     * @param newCapitalCity the capitalCity property value to be added
     */
    void addCapitalCity(String newCapitalCity);

    /**
     * Removes a capitalCity property value.<p>
     * 
     * @param oldCapitalCity the capitalCity property value to be removed.
     */
    void removeCapitalCity(String oldCapitalCity);



    /* ***************************************************
     * Property http://www.owl-ontologies.com/CountryEconomicAspects.owl#countryName
     */
     
    /**
     * Gets all property values for the countryName property.<p>
     * 
     * @returns a collection of values for the countryName property.
     */
    Collection<? extends String> getCountryName();

    /**
     * Checks if the class has a countryName property value.<p>
     * 
     * @return true if there is a countryName property value.
     */
    boolean hasCountryName();

    /**
     * Adds a countryName property value.<p>
     * 
     * @param newCountryName the countryName property value to be added
     */
    void addCountryName(String newCountryName);

    /**
     * Removes a countryName property value.<p>
     * 
     * @param oldCountryName the countryName property value to be removed.
     */
    void removeCountryName(String oldCountryName);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
