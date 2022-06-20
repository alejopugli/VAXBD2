package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationEvent;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.CentreRepository;
import ar.edu.unlp.info.bd2.repositories.NurseRepository;
import ar.edu.unlp.info.bd2.repositories.PatientRepository;
import ar.edu.unlp.info.bd2.repositories.ShotCertificateRepository;
import ar.edu.unlp.info.bd2.repositories.ShotRepository;
import ar.edu.unlp.info.bd2.repositories.StaffRepository;
import ar.edu.unlp.info.bd2.repositories.SupportStaffRepository;
import ar.edu.unlp.info.bd2.repositories.VaccinationScheduleRepository;
import ar.edu.unlp.info.bd2.repositories.VaccineRepository;
import ar.edu.unlp.info.bd2.repositories.VaxException;

public class SpringDataVaxService implements VaxService{

    private PatientRepository patientRepository;
    private StaffRepository staffRepository;
    private VaccineRepository vaccineRepository;
    private CentreRepository centreRepository;
    private ShotCertificateRepository shotCertificateRepository;
    private VaccinationScheduleRepository vaccinationScheduleRepository;
    private ShotRepository shotRepository;
    private NurseRepository nurseRepository;
    private SupportStaffRepository supportStaffRepository;

    @Override
    public List<Patient> getAllPatients() {
        return (List<Patient>) this.patientRepository.findAll();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Centre getTopShotCentre() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return (List<Staff>) this.staffRepository.findByFullNameContaining(name);
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        Patient patient = new Patient(email, fullname, password, dayOfBirth);
        this.patientRepository.save(patient);
        return patient;
    }

    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine vax = new Vaccine(name);
        this.vaccineRepository.save(vax);
        return vax;
    }

    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        Shot shot = new Shot(patient, vaccine, date, centre, nurse);
        this.shotRepository.save(shot);
        return shot;
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        return this.patientRepository.findByEmail(email);
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return this.vaccineRepository.findByName(name);
    }

    @Override
    public Centre createCentre(String name) throws VaxException {
        Centre centre = new Centre(name);
        this.centreRepository.save(centre);
        return centre;
    }

    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        Nurse nurse = new Nurse(dni, fullName, experience);
        this.nurseRepository.save(nurse);
        return null;
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
        this.supportStaffRepository.save(supportStaff);
        return supportStaff;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
        this.vaccinationScheduleRepository.save(vaccinationSchedule);
        return vaccinationSchedule;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return null;//this.vaccinationScheduleRepository.findById(id);
    }

    @Override
    public Optional<Centre> getCentreByName(String name) throws VaxException {
        return this.centreRepository.findByName(name);
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Centre updateCentre(Centre centre) throws VaxException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return this.supportStaffRepository.findByDni(dni);
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) throws VaxException {
        // TODO Auto-generated method stub
        return null;
    }
    
}