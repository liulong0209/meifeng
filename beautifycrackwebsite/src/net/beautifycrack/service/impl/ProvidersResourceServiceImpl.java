package net.beautifycrack.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.beautifycrack.constant.Common;
import net.beautifycrack.dao.FileInfoMapper;
import net.beautifycrack.dao.ProvidersResourceMapper;
import net.beautifycrack.exception.BusinessException;
import net.beautifycrack.module.AntiFake;
import net.beautifycrack.module.BookingCommunity;
import net.beautifycrack.module.ConstructionCase;
import net.beautifycrack.module.FileInfo;
import net.beautifycrack.module.Qualification;
import net.beautifycrack.module.Worker;
import net.beautifycrack.service.ProvidersResourceService;
import net.beautifycrack.util.PagerUtil;

import org.apache.commons.io.FileDeleteStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��˾ �Ŷ� ���˵���Դ�ӿ�ʵ�� (ʩ��������Ϣ��ʩ��������ԤԼС������˾���ʡ���α��ѯ)
 * 
 * ProvidersResourceServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��12��15�� ����7:04:59
 * @author liulong
 */
@Scope("prototype")
@Service("providersResourceService")
public class ProvidersResourceServiceImpl implements ProvidersResourceService
{

    /**
     * ע��dao
     */
    @Resource
    private ProvidersResourceMapper providersResourceMapper;

    /**
     * �ļ�dao
     */
    @Resource
    private FileInfoMapper fileInfoMapper;

    /***************** ʩ������ *****************/
    @Override
    public List<Worker> workerPagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.workerPagerList(param);
    }

    @Override
    public Integer queryWorkerTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryWorkerTotal(providersId);
    }

    @Override
    public void addWorker(Worker worker) throws BusinessException
    {
        providersResourceMapper.addWorker(worker);
    }

    @Override
    public Worker findWorker(Long workerId) throws BusinessException
    {
        return providersResourceMapper.findWorker(workerId);
    }

    @Override
    public void updateWorker(Worker worker) throws BusinessException
    {
        providersResourceMapper.updateWorker(worker);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWorker(Worker worker) throws BusinessException, IOException
    {
        providersResourceMapper.deleteWorker(worker.getId());

        if (worker.getAvatar() != null && worker.getAvatar() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(worker.getAvatar());

            // ɾ�����ݿ�
            fileInfoMapper.delete(worker.getAvatar());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }
    }

    /***************** ʩ������ *****************/

    @Override
    public List<ConstructionCase> workcasePagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.workcasePagerList(param);
    }

    @Override
    public Integer queryWorkcaseTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryWorkcaseTotal(providersId);
    }

    @Override
    public void addWorkcase(ConstructionCase workcase) throws BusinessException
    {
        providersResourceMapper.addWorkcase(workcase);
    }

    @Override
    public ConstructionCase findWorkcase(Long workcaseId) throws BusinessException
    {
        return providersResourceMapper.findWorkcase(workcaseId);
    }

    @Override
    public void updateWorkcase(ConstructionCase workcase) throws BusinessException
    {
        providersResourceMapper.updateWorkcase(workcase);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWorkcase(ConstructionCase workcase) throws BusinessException, IOException
    {
        providersResourceMapper.deleteWorkcase(workcase.getId());
        if (workcase.getImageId() != null && workcase.getImageId() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(workcase.getImageId());

            // ɾ�����ݿ�
            fileInfoMapper.delete(workcase.getImageId());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }

    }

    /***************** ԤԼС�� *****************/

    @Override
    public List<BookingCommunity> bookingPagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.bookingPagerList(param);
    }

    @Override
    public Integer queryBookingTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryBookingTotal(providersId);
    }

    @Override
    public void addBooking(BookingCommunity booking) throws BusinessException
    {
        providersResourceMapper.addBooking(booking);
    }

    @Override
    public BookingCommunity findBooking(Long bookingId) throws BusinessException
    {
        return providersResourceMapper.findBooking(bookingId);
    }

    @Override
    public void updateBooking(BookingCommunity booking) throws BusinessException
    {
        providersResourceMapper.updateBooking(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBooking(BookingCommunity booking) throws BusinessException, IOException
    {
        providersResourceMapper.deleteBooking(booking.getId());
        if (booking.getImageId() != null && booking.getImageId() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(booking.getImageId());

            // ɾ�����ݿ�
            fileInfoMapper.delete(booking.getImageId());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }

    }

    /***************** ��˾���� *****************/

    @Override
    public List<Qualification> qualificationPagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.qualificationPagerList(param);
    }

    @Override
    public Integer queryQualificationTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryQualificationTotal(providersId);
    }

    @Override
    public void addQualification(Qualification qualification) throws BusinessException
    {
        providersResourceMapper.addQualification(qualification);
    }

    @Override
    public Qualification findQualification(Long qualificationId) throws BusinessException
    {
        return providersResourceMapper.findQualification(qualificationId);
    }

    @Override
    public void updateQualification(Qualification qualification) throws BusinessException
    {
        providersResourceMapper.updateQualification(qualification);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQualification(Qualification qualification) throws BusinessException, IOException
    {
        providersResourceMapper.deleteQualification(qualification.getId());
        if (qualification.getImageId() != null && qualification.getImageId() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(qualification.getImageId());

            // ɾ�����ݿ�
            fileInfoMapper.delete(qualification.getImageId());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }

    }

    /***************** ��α��ѯ *****************/

    @Override
    public List<AntiFake> antiFakePagerList(PagerUtil pager, Long providersId) throws BusinessException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("providersId", providersId);
        param.put("startRow", (pager.getPageNo() - 1) * pager.getPageSize());
        param.put("pageSize", pager.getPageSize());
        return providersResourceMapper.antiFakePagerList(param);
    }

    @Override
    public Integer queryAntiFakeTotal(Long providersId) throws BusinessException
    {
        return providersResourceMapper.queryAntiFakeTotal(providersId);
    }

    @Override
    public void addAntiFake(AntiFake antiFake) throws BusinessException
    {
        providersResourceMapper.addAntiFake(antiFake);
    }

    @Override
    public AntiFake findAntiFake(Long antiFakeId) throws BusinessException
    {
        return providersResourceMapper.findAntiFake(antiFakeId);
    }

    @Override
    public void updateAntiFake(AntiFake antiFake) throws BusinessException
    {
        providersResourceMapper.updateAntiFake(antiFake);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAntiFake(AntiFake antiFake) throws BusinessException, IOException
    {
        providersResourceMapper.deleteAntiFake(antiFake.getId());
        if (antiFake.getImageId() != null && antiFake.getImageId() != Common.NO_FILE)
        {
            // ɾ������
            FileInfo fileInfo = fileInfoMapper.findFileById(antiFake.getImageId());

            // ɾ�����ݿ�
            fileInfoMapper.delete(antiFake.getImageId());

            // ɾ���ļ�
            FileDeleteStrategy strategy = FileDeleteStrategy.NORMAL;
            File fileToDelete = new File(fileInfo.getFilePath());
            if (fileToDelete.exists())
            {
                strategy.delete(fileToDelete);
            }
        }

    }

}
