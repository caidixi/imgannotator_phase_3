package wnderful.imgannotator.vo.userVo;

public class AllUserMessagesVo {
    public UserMessageVo[] userMessageVos;

    public AllUserMessagesVo(UserMessageVo[] userMessageVos) {
        this.userMessageVos = userMessageVos;
    }

    public UserMessageVo[] getUserMessageVos() {
        return userMessageVos;
    }

    public void setUserMessageVos(UserMessageVo[] userMessageVos) {
        this.userMessageVos = userMessageVos;
    }
}
