package czy.demo.mavenprj.autogenerator.tools.generator.weitu.pojo.config;

import java.io.Serializable;

/**
 * 自动生成代码的表配置对象
 */
public class GeneratorTableConfigVo implements Serializable {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 别名
     */
    private String aliasName;
    /**
     * 作者
     */
    private String author = "defaultUser";

    public GeneratorTableConfigVo() {

    }

    public GeneratorTableConfigVo(String tableName, String aliasName, String author) {
        this.tableName = tableName;
        this.aliasName = aliasName;
        this.author = author;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
