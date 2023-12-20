//package jp.co.jdsnet.base.handler;
//
//import java.util.List;
//import java.util.Set;
//import org.springframework.boot.validation.MessageInterpolatorFactory;
//import jakarta.websocket.MessageHandler;
//
///**
// * メッセージ出力する機能を提供します.
// */
//public class JsfMessageHandler implements MessageHandler {
//
//    /**
//     * {@inheritDoc }
//     */
//    @Override
//    public void appendMessage(Set<ConstraintViolation<?>> validatedResults) {
//
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//
//        MessageInterpolatorFactory interpolatorFactory
//                                   = MessageInterpolatorFactory.of("Messages", "FormMessages", "FormLabels");
//
//        MessageInterpolator interpolator = interpolatorFactory.create();
//
//        List<ConstraintViolation<?>> sortedValidatedResults = ConstraintViolationSorting.of(validatedResults).toList();
//
//        sortedValidatedResults.stream()
//                .map(result -> {
//                    return interpolator.toMessage(result);
//                })
//                .distinct()
//                .forEachOrdered(message -> {
//
//                    FacesMessage facemsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
//                    facesContext.addMessage(null, facemsg);
//                });
//
//        // リダイレクトしてもFacesMessageが消えないように設定
//        facesContext.getExternalContext().getFlash().setKeepMessages(true);
//
//    }
//
//}