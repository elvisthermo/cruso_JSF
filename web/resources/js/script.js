function verificar(xhr,status,args,dlg,tbl){
    if(args.validationFailed){
        PF(dlg).jq.effect("Shake",{
            times: S
        },100)
    }else{
        PF(dlg).hide();
        PF(tbl).clearFilters();
    }
    
    
}