package com.xxx.ssm.common.services.imp;

import com.xxx.ssm.common.dao.AccountDAO;
import com.xxx.ssm.common.dao.base.BaseAccountInfoDAO;
import com.xxx.ssm.common.dao.base.BasePamAccountDAO;
import com.xxx.ssm.common.entities.AccountInfo;
import com.xxx.ssm.common.entities.PamAccount;
import com.xxx.ssm.common.entities.vo.AccountVO;
import com.xxx.ssm.common.services.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/17.
 */
@Service
public class AccountServiceImp implements AccountService {

    private static Logger logger= LogManager.getLogger(AccountServiceImp.class.getName());

    @Autowired
    private AccountDAO accountDao;
    @Autowired
    private BasePamAccountDAO basePamAccountDAO;
    @Autowired
    private BaseAccountInfoDAO baseAccountInfoDAO;

  /*  *//**
     * 根据账号名称获取一个账号信息
     * @param string
     * @return  PamAccount
     *//*
    public PamAccount getAccountByLoginName(String loginName) {

        pamAccountExample accountExample=new pamAccountExample();
        accountExample.or().andLoginNameEqualTo(loginName);
        return getAccountByExample(accountExample);
    }
    public PamAccount getAccountByAccountId(Integer accountId) {
        pamAccountExample accountExample=new pamAccountExample();
        accountExample.or().andAccountIdEqualTo(accountId);
        return getAccountByExample(accountExample);
    }


    public List<PamAccount> getAccounts(pamAccountExample example) {
        return accountDao.selectByExample(example);
    }

    public int addAccount(PamAccount pamAccount) {
        return accountDao.insert(pamAccount);
    }

    public int updateAccount(PamAccount pamAccount) {
        return accountDao.updateByPrimaryKeySelective(pamAccount);
    }

    public int deletAccount(Integer accountId) {
        return accountDao.deleteByPrimaryKey(accountId);
    }

    public PamAccount getAccountByExample(pamAccountExample example){
        List<PamAccount>  listAccount=accountDao.selectByExample(example);
        if(listAccount.size()!=1){
            return null;
        }else{
            return listAccount.get(0);
        }
    }

    *//**
     * 根据账号id，或者登陆名称获取账号的信息
     * @param map    :  login_name  account_id
     * @return  AccountVO
     *//*
    public AccountVO getAccountInfo(HashMap map){
        return accountDao.getAccountInfo(map);
    }
*/
    /**
     * 保存账号信息
     * @param accountInfo
     */
/*    public void saveAccount(AccountVO accountInfo){
        if(accountInfo.getAccountId()!=null){  //编辑

        }else{  //添加

        }
    }*/

    public AccountVO getAccountInfo(HashMap map) {
        List<AccountVO> accountVOs=accountDao.getAccountInfo(map);
        if(accountVOs.size()==0){
            return null;
        }else{
            return accountVOs.get(0);
        }
    }

    /**
     * 获取用户列表
     * @param map   ： start  , limit
     * @return List<AccountVO>
     */
    public List<AccountVO> getAccountVoList(HashMap map) {
        return  accountDao.getAccountInfo(map);
    }

    /**
     * 保存用户信息
     * @param map
     * @return
     */
    public int saveAccount(HashMap map) {
        AccountInfo   accountInfo=(AccountInfo)map.get("accountInfo");
        PamAccount pamAccount= (PamAccount) map.get("pamAccount");
        if(pamAccount.getAccountId()==null){ //添加
            int id=basePamAccountDAO.insert(pamAccount);
            accountInfo.setAccountId(pamAccount.getAccountId());
            return baseAccountInfoDAO.insert(accountInfo);
        }else{ //编辑
            basePamAccountDAO.updateByPrimaryKeySelective(pamAccount);
            return baseAccountInfoDAO.updateByPrimaryKeySelective(accountInfo);
        }
    }

    public int deleteAccountById(int accountId) {
        basePamAccountDAO.deleteByPrimaryKey(accountId);
        return  baseAccountInfoDAO.deleteByPrimaryKey(accountId);

    }
}
