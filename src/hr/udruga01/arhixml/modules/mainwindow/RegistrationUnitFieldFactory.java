package hr.udruga01.arhixml.modules.mainwindow;

import hr.udruga01.arhixml.datamodel.RegistrationUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.data.Item;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;

/**
 * The custom {@link FormFieldFactory} for the form in which
 * {@link RegistrationUnit} is bound to.
 * <p>
 * By default, {@link Form} will render default components for each JavaBean
 * property. Registering this class on our form will instruct it to use our
 * specific component for each {@link RegistrationUnit} property.
 * <p>
 * This works in a way that {@link Form} will automatically call
 * <code>createField()</code> defined in this class for each
 * {@link RegistrationUnit} property. When this happens we will create our own
 * component that will represent this property and return it as a {@link Field}.
 */
class RegistrationUnitFieldFactory implements FormFieldFactory {
    private static final long serialVersionUID = 1L;
    private final Logger logger = LoggerFactory.getLogger(RegistrationUnitFieldFactory.class.getName());

    private TextField contentsField;
    private TextField holderIdField;
    private TextField levelIdField;
    private TextField nameField;
    private TextField noteField;
    private TextField signatureField;
    private TextField timePeriodNoteField;
    private TextField yearFromField;
    private TextField yearToField;
    private MaterialsCustomField materialField;
    private MediumCustomField mediumField;

    public RegistrationUnitFieldFactory() {
        logger.trace("Entering RegistrationUnitFieldFactory()");
        
        contentsField = new TextField("Sadr�aj");
        contentsField.setWidth("100%");
        contentsField.setNullRepresentation("");

        holderIdField = new TextField("�ifra imatelja");
        holderIdField.setWidth("100%");
        holderIdField.setRequired(true);
        holderIdField.setRequiredError("Molim unesite �ifru imatelja");
        holderIdField.setNullRepresentation("");
        holderIdField.addValidator(new IntegerValidator("�ifra imatelja mora biti broj�ana vrijednost"));
        
        levelIdField = new TextField("�ifra razine");
        levelIdField.setWidth("100%");
        levelIdField.setRequired(true);
        levelIdField.setRequiredError("Molim unesite �ifru razine");
        levelIdField.setNullRepresentation("");
        levelIdField.addValidator(new IntegerValidator("�ifra razine mora biti broj�ana vrijednost"));

        nameField = new TextField("Naziv");
        nameField.setWidth("100%");
        nameField.setRequired(true);
        nameField.setRequiredError("Molim unesite naziv registraturne jedinice");
        nameField.setNullRepresentation("");

        noteField = new TextField("Napomena");
        noteField.setWidth("100%");
        noteField.setNullRepresentation("");

        signatureField = new TextField("Signatura");
        signatureField.setWidth("100%");
        signatureField.setRequired(true);
        signatureField.setRequiredError("Molim unesite �ifru signature");
        signatureField.setNullRepresentation("");
        signatureField.addValidator(new IntegerValidator("Vrijednost signature mora biti broj�ana vrijednost"));

        timePeriodNoteField = new TextField("Napomena o razdoblju");
        timePeriodNoteField.setWidth("100%");
        timePeriodNoteField.setNullRepresentation("");

        yearFromField = new TextField("Godina od");
        yearFromField.setWidth("100%");
        yearFromField.setNullRepresentation("");
        yearFromField.setNullSettingAllowed(true);
        yearFromField.addValidator(new IntegerValidator("Vrijednost godine mora biti broj�ana vrijednost"));

        yearToField = new TextField("Godina do");
        yearToField.setWidth("100%");
        yearToField.setNullRepresentation("");
        yearToField.setNullSettingAllowed(true);
        yearToField.addValidator(new IntegerValidator("Vrijednost godine mora biti broj�ana vrijednost"));

        materialField = new MaterialsCustomField("Gra�a");
        
        mediumField = new MediumCustomField("Medij");
        
        logger.trace("Exiting RegistrationUnitFieldFactory()");
    }

    /**
     * This method will be automatically called by {@link Form} for each
     * {@link RegistrationUnit} property. Our job here is that we create
     * component and return it to the caller for each property.
     */
    @Override
    public Field createField(Item item, Object propertyId, Component uiContext) {
        logger.trace("Entering createField()");
        String beanProperty = (String) propertyId;

        if ("contents".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return contentsField;
        } else if ("holderId".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return holderIdField;
        } else if ("levelId".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return levelIdField;
        } else if ("name".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return nameField;
        } else if ("note".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return noteField;
        } else if ("signature".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return signatureField;
        } else if ("timePeriodNote".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return timePeriodNoteField;
        } else if ("yearFrom".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return yearFromField;
        } else if ("yearTo".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return yearToField;
        } else if ("materials".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return materialField;
        } else if ("mediums".equals(beanProperty)) {
            logger.trace("Exiting createField()");
            return mediumField;
        }

        logger.trace("Exiting createField()");
        return null;
    }
}
