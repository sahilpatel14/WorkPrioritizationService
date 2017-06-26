package entities;

public class Job implements Comparable<Job>{

    private static long globalJobID;

    private final long jobID;
    private final int jobPriority;
    private final Skill requiredSkill;

    public Job(int jobPriority, Skill skill) {
        this.jobPriority = jobPriority;
        this.requiredSkill = skill;
        jobID = globalJobID++;
    }

    public int getJobPriority() {
        return jobPriority;
    }

    public Skill getSkill() {
        return requiredSkill;
    }

    @Override
    public int compareTo(Job other) {

        return this.jobPriority == other.jobPriority ?
                (int) (this.jobID - other.jobID) :
                this.jobPriority - other.jobPriority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Job) {
            return ((Job)obj).jobID == this.jobID;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "("+ getJobPriority()+","+getSkill()+")";
    }
}