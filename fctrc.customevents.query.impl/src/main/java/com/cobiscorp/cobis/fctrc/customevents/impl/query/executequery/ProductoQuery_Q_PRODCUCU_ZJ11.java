/*
 * Archivo: ProductoQuery_Q_PRODCUCU_ZJ11.java
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

package com.cobiscorp.cobis.fctrc.customevents.impl.query.executequery;

import java.util.List;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;
import com.cobiscorp.cobis.commons.domains.log.ILogger;
import com.cobiscorp.cobis.commons.log.LogFactory;
import com.cobiscorp.cobis.fctrc.model.Producto;
import com.cobiscorp.designer.api.DynamicRequest;
import com.cobiscorp.designer.api.customization.IExecuteQuery;
import com.cobiscorp.designer.api.customization.arguments.IExecuteQueryEventArgs;
import com.cobiscorp.designer.api.managers.DesignerManagerException;
import com.cobiscorp.designer.bli.api.IBLIExecutor;

@Component
@Service({ IExecuteQuery.class })
@Properties(value={
		@Property(name = "query.id", value = "Q_PRODCUCU_ZJ11"),
		@Property(name = "query.version", value = "1.0.0")})

public class ProductoQuery_Q_PRODCUCU_ZJ11 implements IExecuteQuery {
	/**
	 * Instancia de Logger
	 */
	private static final ILogger logger = LogFactory.getLogger(ProductoQuery_Q_PRODCUCU_ZJ11.class);

	@Reference(bind="setBliConsultarProductos",
			unbind="unsetBliConsultarProductos",
			cardinality=ReferenceCardinality.MANDATORY_UNARY,
			target = "(bli.id=BLI3055_bli_consultaproductos)")//AQUI ES DONDE SE ATA LA BLI
	private IBLIExecutor bliConsultarProductos;
	
	
	public void setBliConsultarProductos(IBLIExecutor bliConsultarProductos){
		this.bliConsultarProductos=bliConsultarProductos;
	}
	
	public void unsetBliConsultarProductos(IBLIExecutor bliConsultarProductos){
		this.bliConsultarProductos=null;
	}
	@Override
	public List<?> executeDataEvent(DynamicRequest arg0, IExecuteQueryEventArgs arg1) {
		// TODO Auto-generated method stub
		try {
			if (logger.isDebugEnabled()) {
				logger.logDebug("Start executeDataEvent in ProductoQuery_Q_PRODCUCU_ZJ11");
			}
		} catch (Exception ex) {
			DesignerManagerException.handleException(arg1.getMessageManager(), ex, logger);
		}
		bliConsultarProductos.execute(arg0);
		return arg0.getEntityList(Producto.ENTITY_NAME).getDataList();
	}

}

