package be.icc.reservation.form;

import javax.validation.constraints.NotNull;
import java.io.File;

public class FileForm {

    private Integer id;

    @NotNull(message = "{error.common.file}")
    private File file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
