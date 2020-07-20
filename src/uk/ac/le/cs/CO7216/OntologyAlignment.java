package uk.ac.le.cs.CO7216;

import java.io.File;

import org.apache.jena.graph.Factory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.QuerySolutionMap;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.util.FileManager;
//	import com.hp.hpl.jena.util.FileManager;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.log4j.Logger;
import org.apache.xerces.dom.ParentNode;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.RDFNode;
import org.semanticweb.owlapi.io.RDFResource;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.semanticweb.owlapi.model.OWLOntologyFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;	
import org.semanticweb.owlapi.model.IRI;	

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//import org.semanticweb.owlapi.model.OWLOntology;	
//import org.semanticweb.owlapi.model.OWLOntologyManager;

import uk.ac.le.cs.CO7216.*;

public class OntologyAlignment {
	
	 OWLOntologyManager manager;
	 OWLOntology ont; 
	 
	 
	 //Change to your own ontology.
 
	 public static final String ontology="src/uk/ac/le/cs/CO7216/Ontology/CountryEconomicAspects-1.rdf-xml.rdf-xml-2.owl";
	 public static final String ontology_saved="src/uk/ac/le/cs/CO7216/Ontology/CountryEconomicAspects.rdf-xml.rdf-xml_saved_3.owl"; 
	 

	 
	 public OntologyAlignment(){
		 
		 try{
		 
		  manager = OWLManager.createOWLOntologyManager();

		  File ontFile=new File(ontology);
          IRI iri = IRI.create(ontFile);           	 	            
          ont= manager.loadOntologyFromOntologyDocument(iri);
          System.out.println("Loaded ontology: " + ont);
		 
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
          
	 }
	 
	 
	 /**
	 * Question 3
	 * 
	 * propulate()
	 * 
	 * Query RDF store(s) via their
	 * SPARQL endpoints using Jena API. Use the data 
	 * obtained to populate your ontology 
	 * (adding instances). 
	 * @return 
	 */
	 
	public void propulate(){
		 //DBpedia SPARQL endpoint 
		 String sparqlEndpoint="http://dbpedia.org/sparql";		 
		 /*The following SPARQL gets the names, GDP, Official Languages and capital 
		  * cities of African countries, to be added to the ontology
		  */
		 String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" 
						+"PREFIX dct: <http://purl.org/dc/terms/>"
						+"PREFIX type: <http://dbpedia.org/class/yago/>" 
						+"PREFIX prop: <http://dbpedia.org/property/>"
						+" SELECT ?country_name ?capital ?gdpPppPerCapita ?officialLanguages WHERE "
						 +"{ ?country a type:AfricanCountries ;  "
						 +"      rdfs:label ?country_name ;  "
						   +"    prop:capital ?capital ; "    
						 +"prop:gdpPppPerCapita ?gdpPppPerCapita ; "
						+"prop:officialLanguages ?officialLanguages "
						 +"FILTER ( lang(?country_name) = \"en\" ) "
						 +"}";
		 System.out.println("SQL " + sparql);
		 //Question 2.1

				
		 Query query = QueryFactory.create(sparql);
		 
		 
	     QueryExecution qexec =  QueryExecutionFactory.sparqlService(sparqlEndpoint, query);
	     ResultSet results = qexec.execSelect() ;
	     for ( ; results.hasNext() ; ) // Loop through the result to add the values to the Ontology
	     {
			QuerySolution soln = results.nextSolution();

			org.apache.jena.rdf.model.RDFNode cn = soln.get("country_name"); // country_name is a variable in the query
			org.apache.jena.rdf.model.RDFNode Cc = soln.get("capital"); // capital is a variable in the query
			org.apache.jena.rdf.model.RDFNode gd = soln.get("gdpPppPerCapita"); // gdpPppPerCapita is a variable in the query
			org.apache.jena.rdf.model.RDFNode lg = soln.get("officialLanguages"); // officialLanguages is a variable in the query
			String prefix = "http://www.owl-ontologies.com/CountryEconomicAspects.owl#";
						
			String c1 = cn.toString().replace("@en", "");
			String c2 = c1.replace(" ", "_");
			
			OntFactory factory = new OntFactory(ont);
			// Create an instance of country
			Country c3 = factory.createCountry(prefix + c2);
			
			String Cct = Cc.toString().replace("http://dbpedia.org/resource/","");			
			String gdc = gd.toString().replace("^^http://dbpedia.org/datatype/usDollar","");
			String lang = lg.toString().replace("http://dbpedia.org/resource/","");
			String lang_ = lang.replace("@en", "");
			
			 Yearly_GDP_Value yg = factory.createYearly_GDP_Value(prefix + c2 + "/gdpPppPerCapita/$" + gdc);
			 Official_Language ol = factory.createOfficial_Language(prefix + c2 + "/officialLanguages/" +lang_);
			 
			 /**
			  * Here we set the DataType / ObjecType property values
			  */
			 
			 // Add the official languages
			 c3.addUses(ol);
			 
			 // Add the current GDP values in USD
			 c3.addHas(yg);
			 
			// Add the values from the query as the capital city
			c3.addCapitalCity(Cct);
			
				ResultSetFormatter.out(System.out, results, query);
			// complete this method ...
		 	
	     }
		 
	     //ResultSet results = qe.execSelect();	     
	
	     	     
	     qexec.close();	     	    
	     //Complete this method....
		 
	 }
		
	 
	 /**
	  * 
	  *  Question 3
	  * 
	  *  createRelationships()
	  * 
	  *  Set Datatype/Object Property values 
	  *  
	  *  
	  */
	public void createRelationships(){
        
		 try{
		 
          OntFactory factory=new OntFactory (ont);      
			// OWLOntologyFactory factory = new OWLOntologyFactory(ont);
		 
          String prefix = "http://www.owl-ontologies.com/CountryEconomicAspects.owl#" ; 
          Group grp = factory.createGroup(prefix + "ECOWAS");
          
          Geographic_Region wa = factory.createGeographic_Region(prefix + "WestAfrica");
          Geographic_Region na = factory.createGeographic_Region(prefix + "NorthAfrica");
          Geographic_Region ea = factory.createGeographic_Region(prefix + "EastAfrica");

          
          Official_Language eng = factory.createOfficial_Language(prefix + "Engish");
          Official_Language fr = factory.createOfficial_Language(prefix + "French");
          Official_Language ar = factory.createOfficial_Language(prefix + "Arabic");
                    
          Country ng = factory.createCountry(prefix + "Nigeria");
          Country gh = factory.createCountry(prefix + "Ghana");
          Country kn = factory.createCountry(prefix + "Kenya");
          Country lb = factory.createCountry(prefix + "Liberia");
          Country sn = factory.createCountry(prefix + "Senegal");
          Country ey = factory.createCountry(prefix + "Egypt");
          
          // Add official languages to the countries
          ng.addUses(eng);     
          gh.addUses(eng);   
          kn.addUses(eng);
          lb.addUses(eng);
          sn.addUses(fr);
          ey.addUses(ar);
          
          // Add countries to their geographic regions - West, east, north and south Africa
          wa.addContains(ng);
          wa.addContains(sn);
          ea.addContains(kn);
          wa.addContains(gh);
          na.addContains(ey);
               	     	
                   
		 }catch(Exception ex){
			 ex.printStackTrace();
			//System.out.println("Error : "+ ex);
		 }
          
	 }
	 
	 
	 public void save(){
			
			try{
			//	System.out.println("I got here : ");
			File file=new File(ontology_saved);
			 manager.saveOntology(ont, IRI.create(file.toURI()));
			 System.out.println("Saved ontology: " + ont);
			 
			}catch(Exception ex){
				ex.printStackTrace();
			}
			 
		}
	 
	 
	 public static void main(String[] args){

		 
		 OntologyAlignment app=new OntologyAlignment();
		 app.propulate();
		 app.createRelationships();
		 app.save();	 
		 
	 }  
	  
}
