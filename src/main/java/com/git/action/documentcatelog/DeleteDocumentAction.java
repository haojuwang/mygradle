package com.git.action.documentcatelog;

import com.git.exception.EngineException;
import com.git.service.DocumentCatalogService;
import com.git.util.FileStorage;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by lixueqin on 2017/9/22.
 */
public class DeleteDocumentAction extends ActionSupport {
    private Long id;

    private long parentId;
    private int type;

    private String errorMessge;


    private DocumentCatalogService documentCatalogService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentCatalogService getDocumentCatalogService() {
        return documentCatalogService;
    }

    public void setDocumentCatalogService(DocumentCatalogService documentCatalogService) {
        this.documentCatalogService = documentCatalogService;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getErrorMessge() {
        return errorMessge;
    }

    public void setErrorMessge(String errorMessge) {
        this.errorMessge = errorMessge;
    }

    @Override
    public String execute()  {

        try {

            HttpServletRequest request = ServletActionContext.getRequest();
            File directory = new File(FileStorage.getDocumentItemStorage(request));
            documentCatalogService.deleteDocumentCatalog(directory,id);


        } catch (EngineException e) {
           this.errorMessge = e.getMessage();

           return "exception";
        }


        return "success";
    }
}
