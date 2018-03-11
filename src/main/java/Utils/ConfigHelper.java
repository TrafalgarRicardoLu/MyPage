package Utils;

import java.util.Properties;

/**
 * 属性文件助手类
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-05.
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getLocalImgPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.LOCAL_IMG_PATH);
    }

    public static String getServerImgPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.SERVER_IMG_PATH);
    }


}
