/*
 * Archivo: ProductoQuery_QV_IH11_KVQ40.java
 *
 * Esta aplicacion es parte de los paquetes bancarios propiedad de COBISCORP.
 * Su uso no autorizado queda expresamente prohibido asi como cualquier
 * alteracion o agregado hecho por alguno de sus usuarios sin el debido
 * consentimiento por escrito de COBISCORP.
 * Este programa esta protegido por la ley de derechos de autor y por las
 * convenciones internacionales de propiedad intelectual. Su uso no
 * autorizado dara derecho a COBISCORP para obtener ordenes de secuestro
 * o retencion y para perseguir penalmente a los autores de cualquier infraccion.
 */

package com.cobiscorp.cobis.fctrc.customevents.impl.queryview.rowdeleting;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;
import com.cobiscorp.cobis.commons.domains.log.ILogger;
import com.cobiscorp.cobis.commons.log.LogFactory;
import com.cobiscorp.designer.api.DataEntity;
import com.cobiscorp.designer.api.customization.IGridRowDeleting;
import com.cobiscorp.designer.api.customization.arguments.IGridRowActionEventArgs;
import com.cobiscorp.designer.api.managers.DesignerManagerException;
import com.cobiscorp.designer.bli.api.IBLIExecutor;

@Component
@Service({ IGridRowDeleting.class })
@Properties({ @Property(name = "queryView.id", value = "QV_IH11_KVQ40"),
 			  @Property(name = "queryView.controlId", value = "QV_IH11_KVQ40")})

public class ProductoQuery_QV_IH11_KVQ40 implements IGridRowDeleting {
	/**
	 * Instancia de Logger
	 */
	private static final ILogger logger = LogFactory.getLogger(ProductoQuery_QV_IH11_KVQ40.class);
	@Reference(bind="setBliEliminarProducto",
			unbind="unsetBliEliminarProducto",
			cardinality=ReferenceCardinality.MANDATORY_UNARY,
			target = "(bli.id=BLI5553_bli_eliminarproducto)")//AQUI ES DONDE SE ATA LA BLI
	
	private IBLIExecutor blieliminarProducto;
	
	
	public void setBliEliminarProducto(IBLIExecutor blieliminarProducto){
		this.blieliminarProducto=blieliminarProducto;
	}
	
	public void unsetBliEliminarProducto(IBLIExecutor blicrearProducto){
		this.blieliminarProducto=null;
	}
	@Override
	public void rowAction(DataEntity arg0, IGridRowActionEventArgs arg1) {
		// TODO Auto-generated method stub
		try {
			if (logger.isDebugEnabled()) {
				logger.logDebug("Start rowAction in ProductoQuery_QV_IH11_KVQ40");
			}
			blieliminarProducto.execute(arg1.getDynamicRequest());
		} catch (Exception ex) {
			DesignerManagerException.handleException(arg1.getMessageManager(), ex, logger);
		}
	}

}

