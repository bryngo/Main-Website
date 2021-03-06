package org.dcsc.athena.objects;

import java.util.TreeSet;
import java.util.HashMap;
import java.util.*;
import org.dcsc.core.tutor.Tutor;

public class TutorExtension extends Person{

    private TreeSet<String> subjects;
    private String tutoredSubject;
    private HashMap<String, String> tutorMapping;
    private String subjectList;
    private String imgURL;
    private Tutor tutor;
    private String id;

    private Boolean valid;

    public Tutor getTutor() {
        return tutor;
    }

    public void setValid(Boolean n) {
        valid = n;
    }

    public Boolean getValid() {
        return valid;
    }

    public TreeSet<String> getSubjects() {
        return subjects;
    }
    
    public void setTutorSubject(String subject) {
        tutoredSubject = subject;
    }

    public String getTutorSubject() {
        return tutoredSubject;
    }

    public String getURL() {
        return imgURL;
    }

    public HashMap<String, String> getPairingData() {
        return tutorMapping;
    }

    public TutorExtension(String name, String email, TreeSet<String> subjects, String id, Tutor tu) {
        this.name = name;
        this.email = email;
        this.subjects = subjects;
        this.location = "Tutor will arrive shortly.";
        this.tutor = tu;
        this.imgURL = "https://placehold.it/150x150";
        setRoom(id);
        tutorMapping = new HashMap<String, String>();
        tutorMapping.put("TutorName", name);
        tutorMapping.put("TutorLocation", location);
        tutorMapping.put("TutorURL", imgURL);
        tutorMapping.put("StatusType", StatusType.TUTOR_FOUND.toString());
        valid = false;
        this.id = id;

        ArrayList<String> temp = new ArrayList<>(subjects);
        this.subjectList = temp.toString();
    }
    
    public String getSubjectListString() {
            return subjectList;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return this.id;
    }
    
    @Override 
    public int hashCode() {
        if (this.email == null)
            return 0;

        return this.email.hashCode();
    }


    public int compare(TutorExtension o1, TutorExtension o2) {
        return o1.getName().compareTo(o2.getName());
    }


    @Override 
    public boolean equals(Object other) {
        return (other instanceof TutorExtension && ((TutorExtension)other).getEmail().equals(this.getEmail()) && ((TutorExtension)other).getRoom().equals(this.getRoom()));
    }

    @Override
    public String toString() {
        return this.name;
    }
}